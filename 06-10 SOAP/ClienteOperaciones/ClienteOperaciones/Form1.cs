using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteOperaciones
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int a=int.Parse(txtA.Text);
            int b=int.Parse(txtB.Text);

            srOperaciones.BasicasSoapClient obj = new srOperaciones.BasicasSoapClient();
            int r=obj.Sumar(a,b);
            lblResultado.Text="Resultado: "+r.ToString();
            

        }
    }
}
