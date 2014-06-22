package greycrus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;


import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;


import jssc.SerialPort;
import jssc.SerialPortList;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;


import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;


public class SerialLogForMikle {
	private static Boolean isDebug=true;
	private static SerialPort serialPort;
	private static DefaultCategoryDataset[] dataset = new DefaultCategoryDataset[16];
//	private static int imax = 100;
	private static String fullString;
	private static File file1, file2;
	private static FileWriter writeFile1 = null, writeFile2 = null, trashfile = null;
	private static JTextArea buffertextArea;
	private static boolean beResresh = false;
//	private static String portname;

	private static int chartData[][] = new int[16][];

	private static float textFloat[];
	private static JTextArea trashArea;

	private static int myCount = 0;
	private static JButton btnStartButton;
	private static JButton btnStopButton;
	private static JTextField textField1;
	private static JTextField textField2;
	private static JTextField textField3;
	private static JTextField textField4;
	private static JTextField textField5;
	private static JTextField textField6;
	private static JTextField textField7;
	private static JTextField textField8;
	private static JTextField textField9;
	private static JTextField textField10;
	private static JTextField textField11;
	private static JTextField textField12;
	private static JTextField textField13;
	private static JTextField textField14;
	private static JTextField textField15;
	private static JTextField textField16;
	private static JTextField[] textFields = new JTextField[16];
	private static JPanel panelChart1;
	private static JPanel panelChart2;
	private static JPanel panelChart3;
	private static JPanel panelChart4;
	private static JMenuBar menuBar;
	private static JPanel panel;
	private static JPanel panel_1;
	private static JPanel panel_2;
	private static JPanel panel_3;
	private static JComboBox<String> comboBoxPort;
	static List<MyMaches> myMaches = new ArrayList<MyMaches>();
	private static JLabel lblstatusBar;
	private static JLabel lblNewLabel;
	private static JLabel lbl_PackRecievedErrors;
	private static int PackRecieve=0;
	private static int PackErrors=0;
	private static JTextArea logsArea;
	private static JCheckBox chckbxShowTrash;
	private static JCheckBox chckbxSaveTrash;
	private static JPanel panel_Settings;
	private static JLabel lblPlacedGraph_0;
	private static JCheckBox chckbxPlacedGraph_0_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_0_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_0_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_0_on_Chart4;
	private static JLabel lblPlacedGraph_1;
	private static JCheckBox chckbxPlacedGraph_1_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_1_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_1_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_1_on_Chart4;
	private static JLabel lblPlacedGraph_2;
	private static JCheckBox chckbxPlacedGraph_2_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_2_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_2_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_2_on_Chart4;
	private static JLabel lblPlacedGraph_3;
	private static JCheckBox chckbxPlacedGraph_3_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_3_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_3_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_3_on_Chart4;
	private static JLabel lblPlacedGraph_4;
	private static JCheckBox chckbxPlacedGraph_4_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_4_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_4_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_4_on_Chart4;
	private static JLabel lblPlacedGraph_5;
	private static JCheckBox chckbxPlacedGraph_5_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_5_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_5_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_5_on_Chart4;
	private static JLabel lblPlacedGraph_6;
	private static JCheckBox chckbxPlacedGraph_6_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_6_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_6_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_6_on_Chart4;
	private static JLabel lblPlacedGraph_7;
	private static JCheckBox chckbxPlacedGraph_7_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_7_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_7_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_7_on_Chart4;
	private static JLabel lblPlacedGraph_8;
	private static JCheckBox chckbxPlacedGraph_8_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_8_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_8_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_8_on_Chart4;
	private static JLabel lblPlacedGraph_9;
	private static JCheckBox chckbxPlacedGraph_9_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_9_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_9_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_9_on_Chart4;
	private static JLabel lblPlacedGraph_10;
	private static JCheckBox chckbxPlacedGraph_10_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_10_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_10_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_10_on_Chart4;
	private static JLabel lblPlacedGraph_11;
	private static JCheckBox chckbxPlacedGraph_11_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_11_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_11_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_11_on_Chart4;
	private static JLabel lblPlacedGraph_12;
	private static JCheckBox chckbxPlacedGraph_12_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_12_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_12_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_12_on_Chart4;
	private static JLabel lblPlacedGraph_13;
	private static JCheckBox chckbxPlacedGraph_13_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_13_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_13_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_13_on_Chart4;
	private static JLabel lblPlacedGraph_14;
	private static JCheckBox chckbxPlacedGraph_14_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_14_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_14_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_14_on_Chart4;
	private static JLabel lblPlacedGraph_15;
	private static JCheckBox chckbxPlacedGraph_15_on_Chart1;
	private static JCheckBox chckbxPlacedGraph_15_on_Chart2;
	private static JCheckBox chckbxPlacedGraph_15_on_Chart3;
	private static JCheckBox chckbxPlacedGraph_15_on_Chart4;
	private static JCheckBox[][] chckbxPlacedGraphs =new JCheckBox[16][4];
	private static JSpinner Chart0Rate,Chart1Rate,Chart2Rate,Chart3Rate,Chart4Rate,Chart5Rate,Chart6Rate,Chart7Rate,Chart8Rate;
	private static JSpinner Chart9Rate,Chart10Rate,Chart11Rate,Chart12Rate,Chart13Rate,Chart14Rate,Chart15Rate;
	private static JSpinner[] ChartsRate = new JSpinner[16];
	private static JComboBox<String> comboBoxSpeed;
	private static JButton btnClearCharts;
	
    private static String getComment(String key) {
        for (MyMaches lst : myMaches) {
                if (lst.key.equalsIgnoreCase(key))
                        return lst.comment;
        }
        return key;
}


	SerialLogForMikle() {

	};

	public static void main(String[] args) {
		String fileName = "defs.ini";
		if(!isDebug){
		PrintStream st;
		try {
			st = new PrintStream(new FileOutputStream("output_log.txt"));
			System.setErr(st);
			System.setOut(st);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		try {
		System.out.println("New trash");
		trashfile=new FileWriter(new File("trash_log.txt"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		trashfile=null;
	}

		fullString = "";
//		portname = null;
//		if (args.length > 0) {
//			portname = args[0];
//		} else {
//			String[] ports = SerialPortList.getPortNames();
//			if (ports.length > 0)
//				portname = ports[0];
//		}
 		JFrame frame = new JFrame("Hi, Komarov");
 		frame.setBackground(new Color(222, 184, 135));
 		frame.setForeground(new Color(189, 183, 107));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

			
		// Помещаем графики на фрейм
		dataset[0] = new DefaultCategoryDataset();
		JFreeChart chart1 = ChartFactory.createLineChart("Chart 1", "x", "y",
				dataset[0]);
		
		panel_Settings = new JPanel();
		tabbedPane.addTab("Settings", null, panel_Settings, null);
		panel_Settings.setLayout(new GridLayout(0, 6, 0, 0));
		
		lblPlacedGraph_0 = new JLabel("Placed Graph 0 on charts:");
		panel_Settings.add(lblPlacedGraph_0);
		
		Chart0Rate = new JSpinner();
		Chart0Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart0Rate);
		
		chckbxPlacedGraph_0_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_0_on_Chart1);
		
		chckbxPlacedGraph_0_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_0_on_Chart2);
		
		chckbxPlacedGraph_0_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_0_on_Chart3);
		
		chckbxPlacedGraph_0_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_0_on_Chart4);
		
		lblPlacedGraph_1 = new JLabel("Placed Graph 1 on charts:");
		panel_Settings.add(lblPlacedGraph_1);
		
		Chart1Rate = new JSpinner();
		Chart1Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart1Rate);
		
		chckbxPlacedGraph_1_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_1_on_Chart1);
		
		chckbxPlacedGraph_1_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_1_on_Chart2);
		
		chckbxPlacedGraph_1_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_1_on_Chart3);
		
		chckbxPlacedGraph_1_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_1_on_Chart4);

		lblPlacedGraph_2 = new JLabel("Placed Graph 2 on charts:");
		panel_Settings.add(lblPlacedGraph_2);
		
		Chart2Rate = new JSpinner();
		Chart2Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart2Rate);
		
		chckbxPlacedGraph_2_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_2_on_Chart1);
		
		chckbxPlacedGraph_2_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_2_on_Chart2);
		
		chckbxPlacedGraph_2_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_2_on_Chart3);
		
		chckbxPlacedGraph_2_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_2_on_Chart4);
		
		lblPlacedGraph_3 = new JLabel("Placed Graph 3 on charts:");
		panel_Settings.add(lblPlacedGraph_3);
		
		Chart3Rate = new JSpinner();
		Chart3Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart3Rate);
		
		chckbxPlacedGraph_3_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_3_on_Chart1);
		
		chckbxPlacedGraph_3_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_3_on_Chart2);
		
		chckbxPlacedGraph_3_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_3_on_Chart3);
		
		chckbxPlacedGraph_3_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_3_on_Chart4);
		
		lblPlacedGraph_4 = new JLabel("Placed Graph 4 on charts:");
		panel_Settings.add(lblPlacedGraph_4);
		
		Chart4Rate = new JSpinner();
		Chart4Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart4Rate);
		
		chckbxPlacedGraph_4_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_4_on_Chart1);
		
		chckbxPlacedGraph_4_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_4_on_Chart2);
		
		chckbxPlacedGraph_4_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_4_on_Chart3);
		
		chckbxPlacedGraph_4_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_4_on_Chart4);
		
		lblPlacedGraph_5 = new JLabel("Placed Graph 5 on charts:");
		panel_Settings.add(lblPlacedGraph_5);
		
		Chart5Rate = new JSpinner();
		Chart5Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart5Rate);
		
		chckbxPlacedGraph_5_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_5_on_Chart1);
		
		chckbxPlacedGraph_5_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_5_on_Chart2);
		
		chckbxPlacedGraph_5_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_5_on_Chart3);
		
		chckbxPlacedGraph_5_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_5_on_Chart4);

		lblPlacedGraph_6 = new JLabel("Placed Graph 6 on charts:");
		panel_Settings.add(lblPlacedGraph_6);
		
		Chart6Rate = new JSpinner();
		Chart6Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart6Rate);
		
		chckbxPlacedGraph_6_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_6_on_Chart1);
		
		chckbxPlacedGraph_6_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_6_on_Chart2);
		
		chckbxPlacedGraph_6_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_6_on_Chart3);
		
		chckbxPlacedGraph_6_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_6_on_Chart4);

		lblPlacedGraph_7 = new JLabel("Placed Graph 7 on charts:");
		panel_Settings.add(lblPlacedGraph_7);
		
		Chart7Rate = new JSpinner();
		Chart7Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart7Rate);
		
		chckbxPlacedGraph_7_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_7_on_Chart1);
		
		chckbxPlacedGraph_7_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_7_on_Chart2);
		
		chckbxPlacedGraph_7_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_7_on_Chart3);
		
		chckbxPlacedGraph_7_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_7_on_Chart4);

		lblPlacedGraph_8 = new JLabel("Placed Graph 8 on charts:");
		panel_Settings.add(lblPlacedGraph_8);
		
		Chart8Rate = new JSpinner();
		Chart8Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart8Rate);
		
		chckbxPlacedGraph_8_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_8_on_Chart1);
		
		chckbxPlacedGraph_8_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_8_on_Chart2);
		
		chckbxPlacedGraph_8_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_8_on_Chart3);
		
		chckbxPlacedGraph_8_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_8_on_Chart4);

		lblPlacedGraph_9 = new JLabel("Placed Graph 9 on charts:");
		panel_Settings.add(lblPlacedGraph_9);
		
		Chart9Rate = new JSpinner();
		Chart9Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart9Rate);

		chckbxPlacedGraph_9_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_9_on_Chart1);
		
		chckbxPlacedGraph_9_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_9_on_Chart2);
		
		chckbxPlacedGraph_9_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_9_on_Chart3);
		
		chckbxPlacedGraph_9_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_9_on_Chart4);

		lblPlacedGraph_10 = new JLabel("Placed Graph 10 on charts:");
		panel_Settings.add(lblPlacedGraph_10);
		
		Chart10Rate = new JSpinner();
		Chart10Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart10Rate);

		chckbxPlacedGraph_10_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_10_on_Chart1);
		
		chckbxPlacedGraph_10_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_10_on_Chart2);
		
		chckbxPlacedGraph_10_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_10_on_Chart3);
		
		chckbxPlacedGraph_10_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_10_on_Chart4);

		lblPlacedGraph_11 = new JLabel("Placed Graph 11 on charts:");
		panel_Settings.add(lblPlacedGraph_11);
		
		Chart11Rate = new JSpinner();
		Chart11Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart11Rate);

		chckbxPlacedGraph_11_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_11_on_Chart1);
		
		chckbxPlacedGraph_11_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_11_on_Chart2);
		
		chckbxPlacedGraph_11_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_11_on_Chart3);
		
		chckbxPlacedGraph_11_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_11_on_Chart4);
		
		lblPlacedGraph_12 = new JLabel("Placed Graph 12 on charts:");
		panel_Settings.add(lblPlacedGraph_12);
		
		Chart12Rate = new JSpinner();
		Chart12Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart12Rate);

		chckbxPlacedGraph_12_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_12_on_Chart1);
		
		chckbxPlacedGraph_12_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_12_on_Chart2);
		
		chckbxPlacedGraph_12_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_12_on_Chart3);
		
		chckbxPlacedGraph_12_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_12_on_Chart4);

		lblPlacedGraph_13 = new JLabel("Placed Graph 13 on charts:");
		panel_Settings.add(lblPlacedGraph_13);
		
		Chart13Rate = new JSpinner();
		Chart13Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart13Rate);

		chckbxPlacedGraph_13_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_13_on_Chart1);
		
		chckbxPlacedGraph_13_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_13_on_Chart2);
		
		chckbxPlacedGraph_13_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_13_on_Chart3);
		
		chckbxPlacedGraph_13_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_13_on_Chart4);

		lblPlacedGraph_14 = new JLabel("Placed Graph 14 on charts:");
		panel_Settings.add(lblPlacedGraph_14);
		
		Chart14Rate = new JSpinner();
		Chart14Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart14Rate);

		chckbxPlacedGraph_14_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_14_on_Chart1);
		
		chckbxPlacedGraph_14_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_14_on_Chart2);
		
		chckbxPlacedGraph_14_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_14_on_Chart3);
		
		chckbxPlacedGraph_14_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_14_on_Chart4);

		lblPlacedGraph_15 = new JLabel("Placed Graph 15 on charts:");
		panel_Settings.add(lblPlacedGraph_15);
		
		Chart15Rate = new JSpinner();
		Chart15Rate.setModel(new SpinnerNumberModel(new Float(1), new Float(0), null, new Float(1)));
		panel_Settings.add(Chart15Rate);

		chckbxPlacedGraph_15_on_Chart1 = new JCheckBox("On chart 1");
		panel_Settings.add(chckbxPlacedGraph_15_on_Chart1);
		
		chckbxPlacedGraph_15_on_Chart2 = new JCheckBox("On chart 2");
		panel_Settings.add(chckbxPlacedGraph_15_on_Chart2);
		
		chckbxPlacedGraph_15_on_Chart3 = new JCheckBox("On chart 3");
		panel_Settings.add(chckbxPlacedGraph_15_on_Chart3);
		
		chckbxPlacedGraph_15_on_Chart4 = new JCheckBox("On chart 4");
		panel_Settings.add(chckbxPlacedGraph_15_on_Chart4);

		chckbxPlacedGraphs[0][0] = chckbxPlacedGraph_0_on_Chart1; chckbxPlacedGraphs[0][1] = chckbxPlacedGraph_0_on_Chart2;chckbxPlacedGraphs[0][2] = chckbxPlacedGraph_0_on_Chart3;chckbxPlacedGraphs[0][3] = chckbxPlacedGraph_0_on_Chart4;
		chckbxPlacedGraphs[1][0] = chckbxPlacedGraph_1_on_Chart1; chckbxPlacedGraphs[1][1] = chckbxPlacedGraph_1_on_Chart2;chckbxPlacedGraphs[1][2] = chckbxPlacedGraph_1_on_Chart3;chckbxPlacedGraphs[1][3] = chckbxPlacedGraph_1_on_Chart4;
		chckbxPlacedGraphs[2][0] = chckbxPlacedGraph_2_on_Chart1; chckbxPlacedGraphs[2][1] = chckbxPlacedGraph_2_on_Chart2;chckbxPlacedGraphs[2][2] = chckbxPlacedGraph_2_on_Chart3;chckbxPlacedGraphs[2][3] = chckbxPlacedGraph_2_on_Chart4;
		chckbxPlacedGraphs[3][0] = chckbxPlacedGraph_3_on_Chart1; chckbxPlacedGraphs[3][1] = chckbxPlacedGraph_3_on_Chart2;chckbxPlacedGraphs[3][2] = chckbxPlacedGraph_3_on_Chart3;chckbxPlacedGraphs[3][3] = chckbxPlacedGraph_3_on_Chart4;
		chckbxPlacedGraphs[4][0] = chckbxPlacedGraph_4_on_Chart1; chckbxPlacedGraphs[4][1] = chckbxPlacedGraph_4_on_Chart2;chckbxPlacedGraphs[4][2] = chckbxPlacedGraph_4_on_Chart3;chckbxPlacedGraphs[4][3] = chckbxPlacedGraph_4_on_Chart4;
		chckbxPlacedGraphs[5][0] = chckbxPlacedGraph_5_on_Chart1; chckbxPlacedGraphs[5][1] = chckbxPlacedGraph_5_on_Chart2;chckbxPlacedGraphs[5][2] = chckbxPlacedGraph_5_on_Chart3;chckbxPlacedGraphs[5][3] = chckbxPlacedGraph_5_on_Chart4;
		chckbxPlacedGraphs[6][0] = chckbxPlacedGraph_6_on_Chart1; chckbxPlacedGraphs[6][1] = chckbxPlacedGraph_6_on_Chart2;chckbxPlacedGraphs[6][2] = chckbxPlacedGraph_6_on_Chart3;chckbxPlacedGraphs[6][3] = chckbxPlacedGraph_6_on_Chart4;
		chckbxPlacedGraphs[7][0] = chckbxPlacedGraph_7_on_Chart1; chckbxPlacedGraphs[7][1] = chckbxPlacedGraph_7_on_Chart2;chckbxPlacedGraphs[7][2] = chckbxPlacedGraph_7_on_Chart3;chckbxPlacedGraphs[7][3] = chckbxPlacedGraph_7_on_Chart4;
		chckbxPlacedGraphs[8][0] = chckbxPlacedGraph_8_on_Chart1; chckbxPlacedGraphs[8][1] = chckbxPlacedGraph_8_on_Chart2;chckbxPlacedGraphs[8][2] = chckbxPlacedGraph_8_on_Chart3;chckbxPlacedGraphs[8][3] = chckbxPlacedGraph_8_on_Chart4;
		chckbxPlacedGraphs[9][0] = chckbxPlacedGraph_9_on_Chart1; chckbxPlacedGraphs[9][1] = chckbxPlacedGraph_9_on_Chart2;chckbxPlacedGraphs[9][2] = chckbxPlacedGraph_9_on_Chart3;chckbxPlacedGraphs[9][3] = chckbxPlacedGraph_9_on_Chart4;
		chckbxPlacedGraphs[10][0] = chckbxPlacedGraph_10_on_Chart1; chckbxPlacedGraphs[10][1] = chckbxPlacedGraph_10_on_Chart2;chckbxPlacedGraphs[10][2] = chckbxPlacedGraph_10_on_Chart3;chckbxPlacedGraphs[10][3] = chckbxPlacedGraph_10_on_Chart4;
		chckbxPlacedGraphs[11][0] = chckbxPlacedGraph_11_on_Chart1; chckbxPlacedGraphs[11][1] = chckbxPlacedGraph_11_on_Chart2;chckbxPlacedGraphs[11][2] = chckbxPlacedGraph_11_on_Chart3;chckbxPlacedGraphs[11][3] = chckbxPlacedGraph_11_on_Chart4;
		chckbxPlacedGraphs[12][0] = chckbxPlacedGraph_12_on_Chart1; chckbxPlacedGraphs[12][1] = chckbxPlacedGraph_12_on_Chart2;chckbxPlacedGraphs[12][2] = chckbxPlacedGraph_12_on_Chart3;chckbxPlacedGraphs[12][3] = chckbxPlacedGraph_12_on_Chart4;
		chckbxPlacedGraphs[13][0] = chckbxPlacedGraph_13_on_Chart1; chckbxPlacedGraphs[13][1] = chckbxPlacedGraph_13_on_Chart2;chckbxPlacedGraphs[13][2] = chckbxPlacedGraph_13_on_Chart3;chckbxPlacedGraphs[13][3] = chckbxPlacedGraph_13_on_Chart4;
		chckbxPlacedGraphs[14][0] = chckbxPlacedGraph_14_on_Chart1; chckbxPlacedGraphs[14][1] = chckbxPlacedGraph_14_on_Chart2;chckbxPlacedGraphs[14][2] = chckbxPlacedGraph_14_on_Chart3;chckbxPlacedGraphs[14][3] = chckbxPlacedGraph_14_on_Chart4;
		chckbxPlacedGraphs[15][0] = chckbxPlacedGraph_15_on_Chart1; chckbxPlacedGraphs[15][1] = chckbxPlacedGraph_15_on_Chart2;chckbxPlacedGraphs[15][2] = chckbxPlacedGraph_15_on_Chart3;chckbxPlacedGraphs[15][3] = chckbxPlacedGraph_15_on_Chart4;
		
		ChartsRate[0]= Chart0Rate; ChartsRate[1]= Chart1Rate; ChartsRate[2]= Chart2Rate; ChartsRate[3]= Chart3Rate;
		ChartsRate[4]= Chart4Rate; ChartsRate[5]= Chart5Rate; ChartsRate[6]= Chart6Rate; ChartsRate[7]= Chart7Rate;
		ChartsRate[8]= Chart8Rate; ChartsRate[9]= Chart9Rate; ChartsRate[10]= Chart10Rate; ChartsRate[11]= Chart11Rate;
		ChartsRate[12]= Chart12Rate; ChartsRate[13]= Chart13Rate;ChartsRate[14]= Chart14Rate; ChartsRate[15]= Chart15Rate;
		
		panelChart1 = new JPanel();
		tabbedPane.addTab("Chart 1", null, panelChart1, null);
		panelChart1.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel1 = new ChartPanel(chart1);
		chartPanel1.setBackground(new Color(222, 184, 135));
		chartPanel1.setLayout(new GridLayout(2, 1, 0, 0));
		panelChart1.add(chartPanel1, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panelChart1.add(panel, BorderLayout.NORTH);
		
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setForeground(Color.RED);
		textField1.setText("12345");
		textField1.setFont(new Font("Crystal", Font.BOLD, 30));
		panel.add(textField1);
		textField1.setEditable(false);
		textField1.setColumns(10);
		textFields[0]=textField1;
		
		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setText("123.5");
		textField2.setForeground(Color.RED);
		textField2.setFont(new Font("Crystal", Font.BOLD, 30));
		panel.add(textField2);
		textField2.setEditable(false);
		textField2.setColumns(10);
		textFields[1]=textField2;
		
		textField3 = new JTextField();
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setForeground(Color.RED);
		textField3.setText("987");
		textField3.setFont(new Font("Crystal", Font.BOLD, 30));
		panel.add(textField3);
		textField3.setEditable(false);
		textField3.setColumns(10);
		textFields[2]=textField3;
		
		textField4 = new JTextField();
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setText("0123");
		textField4.setForeground(Color.RED);
		textField4.setFont(new Font("Crystal", Font.BOLD, 30));
		panel.add(textField4);
		textField4.setEditable(false);
		textField4.setColumns(10);
		textFields[3]=textField4;

		dataset[1] = new DefaultCategoryDataset();
		JFreeChart chart2 = ChartFactory.createLineChart("Chart 2", "x", "y",
				dataset[1]);

		dataset[2] = new DefaultCategoryDataset();
		
		panelChart2 = new JPanel();
		tabbedPane.addTab("Chart 2", null, panelChart2, null);
		ChartPanel chartPanel2 = new ChartPanel(chart2);
		GroupLayout gl_chartPanel2 = new GroupLayout(chartPanel2);
		gl_chartPanel2.setHorizontalGroup(
			gl_chartPanel2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 680, Short.MAX_VALUE)
		);
		gl_chartPanel2.setVerticalGroup(
			gl_chartPanel2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 420, Short.MAX_VALUE)
		);
		chartPanel2.setLayout(gl_chartPanel2);
		panelChart2.setLayout(new BorderLayout(0, 0));
		panelChart2.add(chartPanel2, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panelChart2.add(panel_1, BorderLayout.NORTH);
		
		textField5 = new JTextField();
		textField5.setHorizontalAlignment(SwingConstants.CENTER);
		textField5.setForeground(Color.RED);
		textField5.setText("12345");
		textField5.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_1.add(textField5);
		textField5.setEditable(false);
		textField5.setColumns(10);
		textFields[4]=textField5;
		
		textField6 = new JTextField();
		textField6.setHorizontalAlignment(SwingConstants.CENTER);
		textField6.setForeground(Color.RED);
		textField6.setText("12345");
		textField6.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_1.add(textField6);
		textField6.setEditable(false);
		textField6.setColumns(10);
		textFields[5]=textField6;
		
		textField7 = new JTextField();
		textField7.setHorizontalAlignment(SwingConstants.CENTER);
		textField7.setForeground(Color.RED);
		textField7.setText("12345");
		textField7.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_1.add(textField7);
		textField7.setEditable(false);
		textField7.setColumns(10);
		textFields[6]=textField7;
		
		textField8 = new JTextField();
		textField8.setHorizontalAlignment(SwingConstants.CENTER);
		textField8.setForeground(Color.RED);
		textField8.setText("12345");
		textField8.setFont(new Font("Crystal", Font.BOLD, 30));		
		panel_1.add(textField8);
		textField8.setEditable(false);
		textField8.setColumns(10);
		textFields[7]=textField8;

		dataset[3] = new DefaultCategoryDataset();
		JFreeChart chart3 = ChartFactory.createLineChart("Chart 3", "x", "y",
				dataset[2]);

		JFreeChart chart4 = ChartFactory.createLineChart("Chart 4", "x", "y",
				dataset[3]);
		panelChart3 = new JPanel();
		tabbedPane.addTab("Chart 3", null, panelChart3, null);
		
		ChartPanel chartPanel3 = new ChartPanel(chart3);
		panelChart3.setLayout(new BorderLayout(0, 0));
		panelChart3.add(chartPanel3);
		
		panel_2 = new JPanel();
		panelChart3.add(panel_2, BorderLayout.NORTH);
		
		textField9 = new JTextField();
		textField9.setHorizontalAlignment(SwingConstants.CENTER);
		textField9.setForeground(Color.RED);
		textField9.setText("12345");
		textField9.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_2.add(textField9);
		textField9.setEditable(false);
		textField9.setColumns(10);
		textFields[8]=textField9; 
		
		textField10 = new JTextField();
		textField10.setHorizontalAlignment(SwingConstants.CENTER);
		textField10.setForeground(Color.RED);
		textField10.setText("12345");
		textField10.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_2.add(textField10);
		textField10.setEditable(false);
		textField10.setColumns(10);
		textFields[9]=textField10;
		
		textField11 = new JTextField();
		textField11.setHorizontalAlignment(SwingConstants.CENTER);
		textField11.setForeground(Color.RED);
		textField11.setText("12345");
		textField11.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_2.add(textField11);
		textField11.setEditable(false);
		textField11.setColumns(10);
		textFields[10]=textField11;
		
		textField12 = new JTextField();
		textField12.setHorizontalAlignment(SwingConstants.CENTER);
		textField12.setForeground(Color.RED);
		textField12.setText("12345");
		textField12.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_2.add(textField12);
		textField12.setEditable(false);
		textField12.setColumns(10);
		textFields[11]=textField12;
		panelChart4 = new JPanel();
		tabbedPane.addTab("Chart 4", null, panelChart4, null);

		ChartPanel chartPanel4 = new ChartPanel(chart4);
		panelChart4.setLayout(new BorderLayout(0, 0));
		panelChart4.add(chartPanel4);
		
		panel_3 = new JPanel();
		panelChart4.add(panel_3, BorderLayout.NORTH);
		
		textField13 = new JTextField();
		textField13.setHorizontalAlignment(SwingConstants.CENTER);
		textField13.setForeground(Color.RED);
		textField13.setText("12345");
		textField13.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_3.add(textField13);
		textField13.setEditable(false);
		textField13.setColumns(10);
		textFields[12]=textField13; 
		
		textField14 = new JTextField();
		textField14.setHorizontalAlignment(SwingConstants.CENTER);
		textField14.setForeground(Color.RED);
		textField14.setText("12345");
		textField14.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_3.add(textField14);
		textField14.setEditable(false);
		textField14.setColumns(10);
		textFields[13]=textField14;
		
		textField15 = new JTextField();
		textField15.setHorizontalAlignment(SwingConstants.CENTER);
		textField15.setForeground(Color.RED);
		textField15.setText("12345");
		textField15.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_3.add(textField15);
		textField15.setEditable(false);
		textField15.setColumns(10);
		textFields[14]=textField15;
		
		textField16 = new JTextField();
		textField16.setHorizontalAlignment(SwingConstants.CENTER);
		textField16.setForeground(Color.RED);
		textField16.setText("12345");
		textField16.setFont(new Font("Crystal", Font.BOLD, 30));
		panel_3.add(textField16);
		textField16.setEditable(false);
		textField16.setColumns(10);
		textFields[15]=textField16;

		buffertextArea = new JTextArea();
		tabbedPane.addTab("TextArea", null, buffertextArea, null);

		trashArea = new JTextArea();
		tabbedPane.addTab("Trash", null, trashArea, null);
		
		menuBar = new JMenuBar();
		
		btnStartButton = new JButton("Start");
		btnStartButton.setForeground(Color.BLACK);
		btnStartButton.setBackground(Color.GREEN);
		menuBar.add(btnStartButton);
		
		btnStopButton = new JButton("Stop");
		btnStopButton.setBackground(Color.RED);
		btnStopButton.setForeground(Color.BLACK);
		btnStopButton.setEnabled(false);
		menuBar.add(btnStopButton);
		btnStopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					serialPort.closePort();
					btnStopButton.setEnabled(false);
					btnStartButton.setEnabled(true);
				} catch (SerialPortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				serialPort= null;
			}
		});
		btnStartButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(serialPort!= null && serialPort.isOpened())
						return;
					
					serialPort = new SerialPort(comboBoxPort.getSelectedItem().toString());
					
					try {
						// Открываем порт
						serialPort.openPort();
						// Выставляем параметры
						serialPort.setParams(Integer.parseInt(comboBoxSpeed.getSelectedItem().toString()),
								SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
						// Включаем аппаратное управление потоком
						serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN
								| SerialPort.FLOWCONTROL_RTSCTS_OUT);
						// Устанавливаем ивент лисенер и маску
						serialPort.addEventListener(new PortReader(),
								SerialPort.MASK_RXCHAR);
						// Отправляем запрос устройству
						// serialPort.writeString("Get data");
						btnStopButton.setEnabled(true);
						btnStartButton.setEnabled(false);
						
					} catch (SerialPortException ex) {
						System.out.println(ex);
						JOptionPane.showMessageDialog(null, "ComPort not found",
								"Воткни компорт!", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
			});
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		btnClearCharts = new JButton("ClearCharts");
		btnClearCharts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int n_Chart=0;n_Chart<4;n_Chart++)
								
						dataset[n_Chart].clear();
	
			}
		});
		btnClearCharts.setBackground(Color.MAGENTA);
		menuBar.add(btnClearCharts);
		
		chckbxShowTrash = new JCheckBox("ShowTrash");
		menuBar.add(chckbxShowTrash);
		
		chckbxSaveTrash = new JCheckBox("Save Trash");
		chckbxSaveTrash.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
//				if(chckbxSaveTrash.isSelected()&&trashfile==null){
//					try {
//						System.out.println("New trash");
//						trashfile=new FileWriter(new File("trash_log.txt"));
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						trashfile=null;
//					}
//				}
//				else if(trashfile!=null){
//						try {
//							System.out.println("close trash");
//							trashfile.flush();
//							trashfile.close();
//							trashfile=null;
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				
			}
		});
		menuBar.add(chckbxSaveTrash);
		
		lbl_PackRecievedErrors = new JLabel("Packs Rec/Err: 0/0 ");
		menuBar.add(lbl_PackRecievedErrors);
		
		lblNewLabel = new JLabel("   Com port : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(lblNewLabel);
		
		comboBoxPort = new JComboBox<String>();
		comboBoxPort.setMaximumRowCount(15);
		menuBar.add(comboBoxPort);
		
		comboBoxSpeed = new JComboBox<String>();
		comboBoxSpeed.setModel(new DefaultComboBoxModel<String>(new String[] {"115200","128000","256000", "57600"}));
		menuBar.add(comboBoxSpeed);
		comboBoxSpeed.setMaximumRowCount(5);
		frame.getContentPane().add(tabbedPane);
		
		logsArea = new JTextArea();
		logsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		logsArea.setText("placed in output_log.txt");
		tabbedPane.addTab("Logs", null, logsArea, null);
		
		lblstatusBar = new JLabel("Loading...");
		frame.getContentPane().add(lblstatusBar, BorderLayout.SOUTH);
		String[] ports = SerialPortList.getPortNames();
        for (String port : ports) {
        	comboBoxPort.addItem(port);
                // System.out.println(port);
        }
        BufferedReader reader;
        String line;
        try {
                reader = new BufferedReader(new FileReader(fileName));
                lblstatusBar.setText("Open "+fileName);

                        while ((line = reader.readLine()) != null) {
                                if (line.startsWith("//")) {
                                        // System.out.println(line);
                                } else if (line.startsWith("$")) {
                                        System.out.println(line);
                                        break;
                                } else //if (line.startsWith("#define !")) 
                                if (line.indexOf("=")>0)
                                {
                                        int posseparate = line.indexOf("=");
                                		//Scanner scanner = new Scanner(line);
                                        //scanner.next();// Define
                                        String key = line.substring(0,posseparate-1);//scanner.next();
                                        key = key.replace(" ", "");key = key.replace(" ", "");key = key.replace(" ", "");key = key.replace(" ", "");
                                        //scanner.next(); // = 
                                        String comment = line.substring(posseparate+1);// scanner.next();
                                        Integer value = 0;
//                                        try { value = new Integer(comment);
//                                        comment="";
//                                        }
//                                        catch(Exception e){}
//                                        
//                                        if (line.indexOf("//") > 0
//                                                        && line.indexOf("//") < (line.length() - 3))
//                                                comment = line.substring(line.indexOf("//"));
                                        //scanner.close();
                                        if(key.equalsIgnoreCase("Title")){
                                        	frame.setTitle(comment); 
                                        }
                                        if(key.equalsIgnoreCase("Series0")){
                                        	lblPlacedGraph_0.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series1")){
                                        	lblPlacedGraph_1.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series2")){
                                        	lblPlacedGraph_2.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series3")){
                                        	lblPlacedGraph_3.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series4")){
                                        	lblPlacedGraph_4.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series5")){
                                        	lblPlacedGraph_5.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series6")){
                                        	lblPlacedGraph_6.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series7")){
                                        	lblPlacedGraph_7.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series8")){
                                        	lblPlacedGraph_8.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series9")){
                                        	lblPlacedGraph_9.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series10")){
                                        	lblPlacedGraph_10.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series11")){
                                        	lblPlacedGraph_11.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series12")){
                                        	lblPlacedGraph_12.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series13")){
                                        	lblPlacedGraph_13.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series14")){
                                        	lblPlacedGraph_14.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
                                        if(key.equalsIgnoreCase("Series15")){
                                        	lblPlacedGraph_15.setText("Показать \""+comment+ " \" на графиках:"); 
                                        }
        
                                        myMaches.add(new MyMaches(key, value, comment));
                                } //else if (line.length() > 5)
                                   //     System.out.println(line);

                        }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }


        //frame.setTitle("Заголовок"); 
		frame.setSize(758, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);// 2*Math.PI
	}
	
	public static int crc16(String string) {
	     int[] table = {
	             0x0000, 0xC0C1, 0xC181, 0x0140, 0xC301, 0x03C0, 0x0280, 0xC241,
	             0xC601, 0x06C0, 0x0780, 0xC741, 0x0500, 0xC5C1, 0xC481, 0x0440,
	             0xCC01, 0x0CC0, 0x0D80, 0xCD41, 0x0F00, 0xCFC1, 0xCE81, 0x0E40,
	             0x0A00, 0xCAC1, 0xCB81, 0x0B40, 0xC901, 0x09C0, 0x0880, 0xC841,
	             0xD801, 0x18C0, 0x1980, 0xD941, 0x1B00, 0xDBC1, 0xDA81, 0x1A40,
	             0x1E00, 0xDEC1, 0xDF81, 0x1F40, 0xDD01, 0x1DC0, 0x1C80, 0xDC41,
	             0x1400, 0xD4C1, 0xD581, 0x1540, 0xD701, 0x17C0, 0x1680, 0xD641,
	             0xD201, 0x12C0, 0x1380, 0xD341, 0x1100, 0xD1C1, 0xD081, 0x1040,
	             0xF001, 0x30C0, 0x3180, 0xF141, 0x3300, 0xF3C1, 0xF281, 0x3240,
	             0x3600, 0xF6C1, 0xF781, 0x3740, 0xF501, 0x35C0, 0x3480, 0xF441,
	             0x3C00, 0xFCC1, 0xFD81, 0x3D40, 0xFF01, 0x3FC0, 0x3E80, 0xFE41,
	             0xFA01, 0x3AC0, 0x3B80, 0xFB41, 0x3900, 0xF9C1, 0xF881, 0x3840,
	             0x2800, 0xE8C1, 0xE981, 0x2940, 0xEB01, 0x2BC0, 0x2A80, 0xEA41,
	             0xEE01, 0x2EC0, 0x2F80, 0xEF41, 0x2D00, 0xEDC1, 0xEC81, 0x2C40,
	             0xE401, 0x24C0, 0x2580, 0xE541, 0x2700, 0xE7C1, 0xE681, 0x2640,
	             0x2200, 0xE2C1, 0xE381, 0x2340, 0xE101, 0x21C0, 0x2080, 0xE041,
	             0xA001, 0x60C0, 0x6180, 0xA141, 0x6300, 0xA3C1, 0xA281, 0x6240,
	             0x6600, 0xA6C1, 0xA781, 0x6740, 0xA501, 0x65C0, 0x6480, 0xA441,
	             0x6C00, 0xACC1, 0xAD81, 0x6D40, 0xAF01, 0x6FC0, 0x6E80, 0xAE41,
	             0xAA01, 0x6AC0, 0x6B80, 0xAB41, 0x6900, 0xA9C1, 0xA881, 0x6840,
	             0x7800, 0xB8C1, 0xB981, 0x7940, 0xBB01, 0x7BC0, 0x7A80, 0xBA41,
	             0xBE01, 0x7EC0, 0x7F80, 0xBF41, 0x7D00, 0xBDC1, 0xBC81, 0x7C40,
	             0xB401, 0x74C0, 0x7580, 0xB541, 0x7700, 0xB7C1, 0xB681, 0x7640,
	             0x7200, 0xB2C1, 0xB381, 0x7340, 0xB101, 0x71C0, 0x7080, 0xB041,
	             0x5000, 0x90C1, 0x9181, 0x5140, 0x9301, 0x53C0, 0x5280, 0x9241,
	             0x9601, 0x56C0, 0x5780, 0x9741, 0x5500, 0x95C1, 0x9481, 0x5440,
	             0x9C01, 0x5CC0, 0x5D80, 0x9D41, 0x5F00, 0x9FC1, 0x9E81, 0x5E40,
	             0x5A00, 0x9AC1, 0x9B81, 0x5B40, 0x9901, 0x59C0, 0x5880, 0x9841,
	             0x8801, 0x48C0, 0x4980, 0x8941, 0x4B00, 0x8BC1, 0x8A81, 0x4A40,
	             0x4E00, 0x8EC1, 0x8F81, 0x4F40, 0x8D01, 0x4DC0, 0x4C80, 0x8C41,
	             0x4400, 0x84C1, 0x8581, 0x4540, 0x8701, 0x47C0, 0x4680, 0x8641,
	             0x8201, 0x42C0, 0x4380, 0x8341, 0x4100, 0x81C1, 0x8081, 0x4040,
	         };


	         byte[] bytes = str2byte(string);//)string.getBytes();
	         int crc = 0xFFFF;//0000;
	         for (byte b : bytes) {
	             crc = (crc >>> 8) ^ table[(crc ^ b) & 0xff];
	         }

	         ////System.out.println("CRC16 = " + Integer.toHexString(crc));

	  	return crc;
	}

	public static String Rotate(int Sum){
		

		 String st = Integer.toHexString(Sum);
		   

		 String stEnd = st.substring(st.length()-2,st.length());

		 String stBeg = st.substring(st.length()-4,st.length()-2);

		 st = stEnd + stBeg;
		// st = stBeg+stEnd ;

		 return st;        
		 }

	private static class PortReader implements SerialPortEventListener {

		public void serialEvent(SerialPortEvent event) {
			if (event.isRXCHAR() && event.getEventValue() > 0) {
				String fullString2 = null;
				try {
					// Получаем ответ от устройства, обрабатываем данные и т.д.
					String data = serialPort.readString(event.getEventValue());
					//if (data.indexOf("@") > 0){ 
					//if (data.substring(0, 2).equals("@@")) {
					//	fullString = data.substring(data.indexOf("@"));
					//}
					//else if (data.substring(0, 1).equals("@")) {
					//	fullString = data.substring(1);
					//}
					// else
					//else {
						fullString += data;
					//}
					while (fullString.indexOf(0x0A) > 0) {
						fullString2=fullString.substring(0);
						if(fullString.indexOf("@",1)==-1) fullString="";
						else fullString = fullString.substring(fullString.indexOf("@",1));
						if (fullString2.startsWith("@")) 
							fullString2 = fullString2.substring(1);
						fullString2 = fullString2.substring(0,
								fullString2.indexOf(0x0A) - 1);
						prepareInputString(fullString2); PackRecieve++;
						
					}

					// И снова отправляем запрос
					// serialPort.writeString("Get data");
				} catch (Exception ex) {
					PackErrors++;
					if(chckbxSaveTrash.isSelected()&&trashfile!=null)
						try {
							trashfile.write("ERR  " +fullString+" - "+ ex+"\r\n" );
							//trashfile.flush();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					System.out.println("fullString2="+fullString2+" "+ex);
					ex.printStackTrace();
				}
				//if(PackRecieve<=PackErrors) PackErrors=0; 
				lbl_PackRecievedErrors.setText("Pack Rec/Err: "+PackRecieve+"/"+PackErrors);
			}
		}
	}

	private static void prepareInputString(String fullString2) {
		// try{
//		if (null == trashArea)
//			return;// trashArea.append("");
		if (beResresh) {
			beResresh = false;
			myCount++;
			// trashArea.removeAll();
			// trashArea.selectAll();
			// trashArea.cut();// removeAll();
			if (myCount > 4) {
				myCount = 0;

				// Refresh

				// buffertextArea.selectAll();
				// buffertextArea.cut();// 
				// buffertextArea.removeAll();

			}
		}
		if(chckbxShowTrash.isSelected())	trashArea.append(new String("" + fullString2 + "\r\n"));
		if(chckbxSaveTrash.isSelected()&&trashfile!=null)
			try {
				trashfile.write("" + fullString2+"\r\n" );
				//trashfile.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		// System.out.println("-=- Get data : "+fullString);
		// first 2 symbols - command
		String command = fullString2.substring(0, 2);
		// last 2 bytes - CRC
		String CRCSymbols = fullString2.substring(fullString2.length() - 4);
		fullString2 = fullString2.substring(2, fullString2.length() - 4);
		if (true){
			int crc16 = crc16(command+fullString2);//ModRTU_CRC(bdata);
			if(crc16!=str2int(CRCSymbols)[0]) {PackErrors++;
			if(chckbxSaveTrash.isSelected()&&trashfile!=null)
				try {
					trashfile.write("ERR CRC16! " + crc16+"<>"+str2int(CRCSymbols)[0]+"\r\n" );
					//trashfile.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		if (command.equals("FF")) {
//			byte[] bdata = str2byte(command+fullString);
//			int crc16 = ModRTU_CRC(bdata);
//			trashArea.append(new String("MyCRC16="+Rotate(crc16)+"-=- "+CRCSymbols + "\n"));

			beResresh = true;
			if (null != textFloat&&chckbxShowTrash.isSelected()) {
				buffertextArea.append("----------------------\n");
			}
			if (null != textFloat)	for (int i = 0; i < textFloat.length; i++) {
					textFields[i].setText(""+Float.toString(textFloat[i])); 

				}
			
			for (int Numchart = 0; Numchart < 16; Numchart++) {
				if (null == chartData[Numchart])
					continue;
				//	dataset[0];
				for (int i = 0; i < chartData[Numchart].length; i++) {
					String namechart =getComment("Series" + Numchart);
					// Теперь не делим на 4 - а указываем куда именно "чартить"
					//dataset[(int) (Numchart / 4)].addValue(
					//		chartData[Numchart][i], namechart, " "
					//				+ i);
					for(int n_Chart=0;n_Chart<4;n_Chart++){
					if(chckbxPlacedGraphs[Numchart][n_Chart].isSelected()){				
						dataset[n_Chart].addValue(
								chartData[Numchart][i]*(Float)ChartsRate[Numchart].getValue(), namechart, " "
										+ i);
						}
					}
					}
			}
			//

		} else if (command.startsWith("0")) {
			int numChart = Integer.parseInt("" + command.charAt(1), 16);// command.charAt(1)
																		// -
																		// '0';
			try {
				chartData[numChart] = str2int(fullString2);
				//trashArea
				//		.append(new String("Set chart " + numChart + " l="
				//				+ chartData[numChart].length + " " + fullString
				//				+ "\n"));
			} catch (Exception e) {
				System.out.println("" + fullString2);
			}
		} else if (command.equals("50")) {

			//trashArea.append(new String("Set values l=" + fullString.length()
			//		/ 2 + " data = " + fullString + "\n"));
			textFloat = str2float(fullString2);

		} else if (command.equals("80")) {

			//trashArea.append(new String("Open File1 " + fullString + "\n"));
			String filename = str2String(fullString2);
			// System.out.println("Open File1 "+ fullString+" -=- "+ filename +
			// "\n");
			try {
				file1 = new File(filename);
				writeFile1 = new FileWriter(file1);
			} catch (IOException e) {
				e.printStackTrace();
			} // finally {
		} else if (command.equals("81")) {

			//trashArea.append(new String("Write to File1 " + fullString + "\n"));
			String tofile = str2String(fullString2);
			// System.out.println("Write to File1 " +fullString+" -=- "+ tofile
			// + "\n");
			if (writeFile1 != null) {
				try {
					writeFile1.write(tofile + "\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (command.equals("83")) {
			// System.out.println("Close File1 " + fullString + "\n");
			//trashArea.append(new String("Close File1 " + fullString + "\n"));
			if (writeFile1 != null) {
				try {
					writeFile1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (command.equals("85")) {

			//trashArea.append(new String("Open File2 " + fullString + "\n"));
			String filename = str2String(fullString2);
			try {
				file2 = new File(filename);
				writeFile2 = new FileWriter(file2);
			} catch (IOException e) {
				e.printStackTrace();
			} // finally {
		} else if (command.equals("86")) {

			//trashArea.append(new String("Write to File2 " + fullString + "\n"));
			String tofile = str2String(fullString2);
			if (writeFile2 != null) {
				try {
					writeFile2.write(tofile + "\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (command.equals("87")) {

			//trashArea.append(new String("Close File2 " + fullString + "\n"));
			if (writeFile2 != null) {
				try {
					writeFile2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		else {
			if(chckbxShowTrash.isSelected()) trashArea.append(new String(command + " -=- " + fullString2
					+ " -=- " + CRCSymbols + "\n"));
		}
		// }catch( Exception e)
		// {}
	}

	private static float[] str2float(String ParamString) {
		float[] retFloat = new float[ParamString.length() / 8];
		byte[] bdata = str2byte(ParamString);
		byte[] b = new byte[] { 0, 0, 0, 0 };
		short j = 0;
		for (short i = 0; i < bdata.length; i += 4) {
			b[0] = (byte) bdata[i + 3];
			b[1] = (byte) bdata[i + 2];
			b[2] = (byte) bdata[i + 1];
			b[3] = (byte) bdata[i + 0];
			retFloat[j++] = ByteBuffer.wrap(b).getFloat();
		}
		return retFloat;
	}

	private static String str2String(String ParamString) {
		byte[] bdata = str2byte(ParamString);
		String retstring = null;
		try {
			retstring = new String(bdata, "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retstring;
	}

	private static int[] str2int(String ParamString) {
		int[] retShort = new int[ParamString.length() / 4];
		short j = 0;
		for (int i = 0; i < ParamString.length() - 1; i += 4) {
			/*
			 * Grab the hex in pairs
			 */
			String output = // ""+
			ParamString.substring(i + 2, i + 3)
					+ ParamString.substring(i + 3, i + 4)
					+ ParamString.substring(i, i + 1)
					+ ParamString.substring(i + 1, i + 2);
			/*
			 * Convert Hex to Decimal
			 */
			retShort[j++] = Integer.parseInt(output, 16);

		}
		return retShort;
	}

	private static final byte[] str2byte(String str) {
		byte[] arrayBytes = new byte[str.length() / 2];
		short j = 0;
		for (short i = 0; i < str.length() - 1; i += 2) {
			String output = // ""+
			str.substring(i + 0, i + 1) + str.substring(i + 1, i + 2);
			int intv = Integer.parseInt(output, 16);
			if (intv > 128)
				intv -= 256;
			arrayBytes[j++] = (byte) intv;// ( (str.charAt(i ) - '0')*16 + 1*
											// (byte) (str
			// .charAt(i+ 1) - '0'));
		}
		return arrayBytes;
	}
}
