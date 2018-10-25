import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public  class PatientForm extends JFrame implements ActionListener, PopupMenuListener 
	{
	
	JLabel lblPatientId,lblPatientName,lblP_Gender,lblP_Age,lblAp_Date,lblP_Problem;
	JComboBox<Integer>cboPatientId;
	JComboBox<Integer> cboPatientAge;
	JTextField txtPatientName,txtP_Gender,txtAppDate;
	JComboBox<String>cboPatientProblem;
	JButton BtnSave,BtnRemove,BtnReset;
	
	public PatientForm()
	{
		super("Patient Master");
		lblPatientId=new JLabel("Patient Id");
		lblPatientName=new JLabel("Patient Name");
		lblP_Gender=new JLabel("Gender");
		lblP_Age=new JLabel("Age");
		lblAp_Date=new JLabel("Appointment Date");
		lblP_Problem=new JLabel("Problem");
		
		cboPatientId=new JComboBox<Integer>();
		txtPatientName=new JTextField();
		txtP_Gender=new JTextField();
		cboPatientAge=new JComboBox<Integer>();
		txtAppDate=new JTextField();
		cboPatientProblem=new JComboBox<String>();
		BtnSave=new JButton("Save");
		BtnRemove=new JButton("Remove");
		BtnReset=new JButton("Reset");
		
		cboPatientId.setEditable(true);
		cboPatientAge.setEditable(true);
		cboPatientProblem.setEditable(true);
		this.setLayout(null);
		
		lblPatientId.setBounds(100,100,100,20);
		cboPatientId.setBounds(280,100,100,20);
		
		lblPatientName.setBounds(100,150,100,20);
		txtPatientName.setBounds(280,150,100,20);
		
		lblP_Gender.setBounds(100,200,100,20);
		txtP_Gender.setBounds(280, 200, 100, 20);
		
		lblP_Age.setBounds(100,250,100,20);
		cboPatientAge.setBounds(280,250,100,20);
		
		lblAp_Date.setBounds(100,300,100,20);
		txtAppDate.setBounds(280, 300, 100, 20);
		
		lblP_Problem.setBounds(100,350,100,20);
		cboPatientProblem.setBounds(280,350,100,20);
		
		BtnSave.setBounds(100,450,80,20);
		BtnRemove.setBounds(200,450,80,20);
		BtnReset.setBounds(300, 450, 80, 20);
		
		this.add(lblPatientId);
		this.add(cboPatientId);
		this.add(lblPatientName);
		this.add(txtPatientName);	
		this.add(lblP_Gender);
		this.add(txtP_Gender);
		this.add(lblP_Age);
		this.add(cboPatientAge);
		this.add(lblAp_Date);
		this.add(txtAppDate);
		this.add(lblP_Problem);
		this.add(cboPatientProblem);
		this.add(BtnSave);
		this.add(BtnRemove);
		this.add(BtnReset);
		
		cboPatientId.addActionListener(this);
		cboPatientId.addPopupMenuListener(this);
		BtnSave.addActionListener(this);
		setSize(500,600);
		//setTitle("Background Color for JFrame");
		 //setSize(600,600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setVisible(true);
		  // Get the container and set the background
		 getContentPane().setBackground(Color.CYAN);
		 }
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new PatientForm();			
	}
	 
	
	public void popupMenuCanceled(PopupMenuEvent arg0){
		
	}
	public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0){
		
	}
	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		PatientDAO adao=new PatientDAO();
		try {
			List<Integer>ids=adao.getAllPatientIds();
			cboPatientId.removeAllItems();
			for(Integer i:ids)
			{
				cboPatientId.addItem(i);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		
	}
	
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()==BtnSave)
		{
			PatientDAO adao=new PatientDAO();
			try {
				adao.addPatient(new Patient(Integer.parseInt(cboPatientId.getSelectedItem().toString()),txtPatientName.getText(),txtP_Gender.getText(),Integer.parseInt(cboPatientAge.getSelectedItem().toString()),txtAppDate.getText(),cboPatientProblem.getSelectedItem().toString()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
		int aid=-1;
		if(cboPatientId.getSelectedItem()!=null){
			
			aid=Integer.parseInt(cboPatientId.getSelectedItem().toString());
		    PatientDAO adao=new PatientDAO();
		    try {
				Patient patient=(Patient) adao.getPatientById(aid);
				txtPatientName.setText(patient.getPatientName());
				txtP_Gender.setText(patient.getP_Gender()+"");
				txtAppDate.setText(patient.getAppointmentDate()+"");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		    
		}
		else
			return;
	}
	
}
