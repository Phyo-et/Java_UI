package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList extends JFrame implements ActionListener {
    private JLabel taskLabel;
    private JTextField taskArea;
    private JButton addBtn;
    private JList<String> listGroup;
    private JButton removeBtn;
    private JButton clearBtn;
    private DefaultListModel listModel;
    
    public TodoList(){
        initializationComponent();
        addUIComponent();
    }

    private void addUIComponent() {
        this.setLayout(new BorderLayout(10,10));

        JPanel taskPanel = new JPanel();
        taskPanel.add(taskLabel);
        taskPanel.add(taskArea);
        taskPanel.add(addBtn);
        this.add(taskPanel,BorderLayout.NORTH);

        JPanel listPanel = new JPanel(new BorderLayout(5,5));
        listPanel.add(new JScrollPane(listGroup),BorderLayout.CENTER);
        this.add(listPanel,BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.add(removeBtn);
        btnPanel.add(clearBtn);
        this.add(btnPanel,BorderLayout.SOUTH);

        this.setTitle("To Do List");
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        System.out.println("UI");
    }

    private void initializationComponent() {

        this.taskLabel = new JLabel("Task : ");
        this.taskArea =  new JTextField(15);
        this.addBtn = new JButton("Add");
        this.removeBtn = new JButton("Remove");
        this.clearBtn = new JButton("Clear");

        this.listModel = new DefaultListModel<>();
        this.listGroup = new JList<>(listModel);
        listGroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        System.out.println("init Component");

        this.addBtn.addActionListener(this);
        this.removeBtn.addActionListener(this);
        this.clearBtn.addActionListener(this);
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            addTask();
        } else if ( e.getSource()== removeBtn) {
            removeTask();
        } else if (e.getSource() == clearBtn) {
            clearTask();
        }
    }

    private void addTask() {
        String task = taskArea.getText();
        if( task.isEmpty() ){
            JOptionPane.showMessageDialog(this,"Please Enter the Task"," ",JOptionPane.INFORMATION_MESSAGE);

        }else{
            listModel.addElement(task);
        }
    }

    private void removeTask() {
        int selectedIndex = listGroup.getSelectedIndex();
        if( selectedIndex != -1){
            listModel.remove(selectedIndex);
        }else{
            JOptionPane.showMessageDialog(this,"Please select the List want to remove","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearTask() {
        listModel.clear();
    }
}
