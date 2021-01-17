package kata5.View;

import javax.swing.JPanel;
import kata5.Model.Histogram;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import java.awt.Dimension;

public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram, String title) {
      super(title);
      this.histogram = histogram;
      this.setContentPane(createPanel());
      this.pack();
    }
    
    public void execute() {
        this.setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart freeChart = ChartFactory.createBarChart3D("JfreeChart Histogram", "emails domains", "nº emails", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
                return freeChart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int others = 0;
        for (String key : histogram.keySet()) {
            int value = histogram.get(key);
            if(value > 1) {
                dataSet.addValue(value, "", key);
            } else {
                others++;
            }
        }
        dataSet.addValue(others, "", "others");
        
        return dataSet;
    }
}
