
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
class First {
	public static void main(String[] args) throws IOException
	{
        Frame f = new Frame ("Resume Builder");

        Label empty = new Label("                                                                                                                                               ");
        Label empty1 = new Label("                                               ");
        Label socialspace = new Label("          ");
        Label skillspace = new Label("                    ");
        Label qualispace = new Label("                                                                                                                                    ");
        Label phonespace = new Label("                          ");
        Label emailSpace = new Label("                                                                                 ");
        Label buttonSpace = new Label("                                          ");
        Label educationSpace = new Label("                                                                             ");
        
        
        Label summary = new Label("About Yourself: ");
        Label personaldetails = new Label("\nPERSONAL DETAILS");
        Label firstName = new Label("First Name: ", Label.LEFT);
        Label lastName = new Label("Last Name: ", Label.RIGHT);
        Label email = new Label("\nEmail: ", Label.LEFT);
        Label address = new Label("\nAddress: ", Label.LEFT);
        Label phoneNo = new Label("Phone Number: ", Label.LEFT);
        Label education = new Label("EDUCATIONAL BACKGROUND");
        Label qualification = new Label("Qualifications: ");
        Label skills = new Label("Skills:- ");
        Label social = new Label("Mention social links, if any: ");
        Label enter = new Label("Click on 'Submit' if you're done: ");
        
        final TextField firstNameText = new TextField(15);
        final TextField lastNameText = new TextField(15);
        final TextField emailText = new TextField(30);
        final TextField phoneText = new TextField(15);
       
        final TextArea addressText=new TextArea();  
        final TextArea summarytext = new TextArea();
        summarytext.setBounds(10,  30, 50, 50);
        TextArea educationText=new TextArea();  
        educationText.setBounds(10,30, 50,50); 
        final TextArea qualificationText=new TextArea();  
        qualificationText.setBounds(10,30, 50,50); 

        final Checkbox checkbox1 = new Checkbox("Java", true);  
        checkbox1.setBounds(100,100, 50,50); 
        final Checkbox checkbox2 = new Checkbox("C++");  
        checkbox2.setBounds(100,150, 50,50);   
        final Checkbox checkbox3 = new Checkbox("Python");  
        checkbox3.setBounds(100,200, 50,50);  
        
        final Checkbox checkbox4 = new Checkbox("Github");
        final Checkbox checkbox5 = new Checkbox("LinkedIn");
        final Checkbox checkbox6 = new Checkbox("Kaggle");

        Button submit = new Button ("Submit");

        f.add(personaldetails); f.add(empty);
        f.add(summary); f.add(summarytext);
        f.add(firstName); f.add(firstNameText);
        f.add(lastName); f.add(lastNameText);
        f.add(empty1);
        f.add(email); f.add(emailText);
        f.add(emailSpace);
        f.add(address); f.add(addressText);
        f.add(phonespace);
        f.add(phoneNo); f.add(phoneText);
        f.add(educationSpace);
        f.add(education);f.add(qualispace);
        f.add(qualification); f.add(qualificationText);
        f.add(skillspace);
        f.add(skills); f.add(checkbox1); f.add(checkbox2); f.add(checkbox3);
        f.add(socialspace);
        f.add(social); f.add(checkbox4); f.add(checkbox5); f.add(checkbox6);
        f.add(buttonSpace);
        f.add(enter);
        f.add(submit);
        
        submit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
        		String finalresume;
                finalresume = "\nResume Details:- ";
                finalresume = addString(finalresume, summarytext.getText(), "About Yourself: ");
                finalresume = addString(finalresume, firstNameText.getText(), "First Name: ");
                finalresume = addString(finalresume, lastNameText.getText(), "Last Name: ");
                finalresume = addString(finalresume, emailText.getText(), "Email: ");
                finalresume = addString(finalresume, phoneText.getText(), "Phone Number: ");
                finalresume = addString(finalresume, addressText.getText(), "Address: ");
               
                finalresume = addString(finalresume, qualificationText.getText(), "Qualifications: ");
                finalresume = addString(finalresume, "", "Skills: ");
                finalresume = addString(finalresume, "", "Social Links: ");
                
                if(checkbox1.getState() == true)
                    finalresume = finalresume+"\nJava";
                if(checkbox2.getState() == true)
                    finalresume = finalresume+"\nC++";
                if(checkbox3.getState() == true)
                    finalresume = finalresume+"\nPython";
                
                if(checkbox4.getState() == true)
                	finalresume = finalresume+"\nGithub";
                if(checkbox5.getState() == true)
                	finalresume = finalresume+"\nLinkedIn";
                if(checkbox6.getState() == true)
                	finalresume = finalresume+"\nKaggle";
                
                System.out.println(finalresume);
                
                try {
                	File file = new File("./resume_file.txt");
                    FileOutputStream fos = new FileOutputStream(file);
                    if(!file.exists())
                        file.createNewFile();
                    byte[] bytesArray = finalresume.getBytes();
                    fos.write(bytesArray);
                    fos.flush();
                    System.out.println("File written successfully");
                    fos.close();
                    }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
                }
        });
        
        f.setLayout(new FlowLayout());

        f.setSize(700, 800);
        f.setVisible(true);
}

public static String addString(String finalresume, String temp, String adder){
    adder="\n"+adder;
    return (finalresume+adder+temp);
	}
}
