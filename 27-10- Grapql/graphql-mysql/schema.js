const { GraphQLObjectType, GraphQLString, GraphQLSchema, GraphQLList, GraphQLNonNull } = require('graphql');
const { Agenda } = require('./database'); // Asegúrate de que el modelo Agenda esté correctamente exportado desde tu archivo de base de datos

// Definición del tipo Agenda en GraphQL
const AgendaType = new GraphQLObjectType({
  name: 'Agenda',
  fields: {
    id: { type: GraphQLString },
    ci: { type: GraphQLString },
    nombres: { type: GraphQLString },
    apellidos: { type: GraphQLString },
    celular: { type: GraphQLString },
    email: { type: GraphQLString },
    profesion_id: { type: GraphQLString }
 
  }
});

// Definición de las consultas (queries)
const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    agendas: {
      type: new GraphQLList(AgendaType),
      resolve(parent, args) {
        // Obtener todas las agendas
        return Agenda.findAll();
      }
    },
    agenda: {
      type: AgendaType,
      args: { id: { type: GraphQLString } },
      resolve(parent, args) {
        // Buscar una agenda por ID
        return Agenda.findByPk(args.id);
      }
    }
  }
});

// Definición de las mutaciones
const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addAgenda: {
      type: AgendaType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        nombres: { type: new GraphQLNonNull(GraphQLString) },
        apellidos: { type: GraphQLString },
        celular: { type: new GraphQLNonNull(GraphQLString) },
        email: { type: new GraphQLNonNull(GraphQLString) },
        profesion_id: { type: new GraphQLNonNull(GraphQLString) }
      },
      resolve(parent, args) {
        // Crear una nueva agenda
        return Agenda.create({
          ci: args.ci,
          nombres: args.nombres,
          apellidos: args.apellidos,
          celular: args.celular,
          email: args.email,
          profesion_id: args.profesion_id
        });
      }
    },
    updateAgenda: {
      type: AgendaType,
      args: {
        id: { type: new GraphQLNonNull(GraphQLString) },
        ci: { type: GraphQLString },
        nombres: { type: GraphQLString },
        apellidos: { type: GraphQLString },
        celular: { type: GraphQLString },
        email: { type: GraphQLString },
        profesion_id: { type: GraphQLString }
      },
      resolve(parent, args) {
        // Actualizar una agenda existente
        return Agenda.findByPk(args.id)
          .then(agenda => {
            if (!agenda) {
              throw new Error('Agenda no encontrada');
            }
            return agenda.update({
              ci: args.ci !== undefined ? args.ci : agenda.ci,
              nombres: args.nombres !== undefined ? args.nombres : agenda.nombres,
              apellidos: args.apellidos !== undefined ? args.apellidos : agenda.apellidos,
              celular: args.celular !== undefined ? args.celular : agenda.celular,
              email: args.email !== undefined ? args.email : agenda.email,
              profesion_id: args.profesion_id !== undefined ? args.profesion_id : agenda.profesion_id
            });
          });
      }
    }
  }
});

// Exporta el esquema GraphQL
module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});
