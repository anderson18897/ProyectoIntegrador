package Formularios;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.*;
import java.util.ArrayList;

public class Histograma extends javax.swing.JFrame {
    static ArrayList<String> datos = new ArrayList<>();

    public Histograma() {

        datos.clear();//limpiamos el array list para que no se duplique los datos cada ves que se llama a la ventana
        for(int i = 0; i< Ventana.datos1.size(); i++){
            datos.add(String.valueOf(Ventana.datos1.get(i)));//aca obtenemos los valores del arreglo de la clase Ventana  y lo guardamos en una lista local es decir en esta clase
        }

        initComponents();
        JPanel chartPanel = crearPanel();
        chartPanel.setBounds(700, 100, 500, 475);
        setContentPane(chartPanel);

    }

    private void initComponents() {

        jPanel1 = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 516, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 335, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(319, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private static IntervalXYDataset crearDataset() {

        double[] miarray = new double[datos.size()];
        for(int i=0; i<datos.size(); i++){
            miarray[i]= Double.parseDouble(datos.get(i));
        }


        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Frecuencias de los Datos", miarray, Ventana.f.size());
        return dataset;
    }


    private static JFreeChart crearChart(IntervalXYDataset dataset) {
        JFreeChart chart = ChartFactory.createHistogram("Histograma Intervalo "+ Ventana.f.size(),null,null,dataset,PlotOrientation.VERTICAL,true,true,false);

        XYPlot plot = (XYPlot) chart.getPlot();
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(true);
        renderer.setBaseSeriesVisible(true);
        return chart;
    }

    public static JPanel crearPanel() {
        JFreeChart chart = crearChart(crearDataset());
        return new ChartPanel(chart);
    }

    private JPanel jPanel1;
}
