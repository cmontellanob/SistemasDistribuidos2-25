const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('bd_agenda_api', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});


const Agenda = sequelize.define('Agenda', {
  id: {
    type: Sequelize.BIGINT,
    allowNull: false,
    primaryKey: true,
    autoIncrement: true,
    unsigned: true // Aquí especificamos que es UNSIGNED
  },
  ci: {
    type: Sequelize.STRING(9),
    allowNull: false
  },
  nombres: {
    type: Sequelize.STRING(50),
    allowNull: false
  },
  apellidos: {
    type: Sequelize.STRING(30),
    allowNull: true
  },
  celular: {
    type: Sequelize.STRING(20),
    allowNull: false
  },
  email: {
    type: Sequelize.STRING(255),
    allowNull: false
  },
  profesion_id: {
    type: Sequelize.BIGINT,
    allowNull: false,
    unsigned: true // Agregamos unsigned: true para el BIGINT UNSIGNED
  }
  
}, {
  tableName: 'agendas',
  timestamps: true, // Para manejar los campos created_at y updated_at automáticamente
  createdAt: 'created_at',
  updatedAt: 'updated_at'
});

module.exports = Agenda;

