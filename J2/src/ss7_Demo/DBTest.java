/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss7_Demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class DBTest {
    Connection cnn;
    Scanner s = new Scanner(System.in);

    public DBTest() {
    cnn = DBConnection.getDBConnection();
    }
    
    public void testConnection(){
        if(this.cnn == null){
            System.out.println("Cannot connect database " + DBConnection.database);
        }else{
            System.out.println("Database connected successfully.");
        }
    }
    
    public void dbSelect(){
        String sql = "Select * from Item";
        try {
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String code = rs.getString(1);
                String name = rs.getString("ItemName");
                int price = rs.getInt("Rate");
                System.out.println(code + "\t\t" + name + "\t\t" + price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ss7_JDBC.DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void dbInsert(){
        String code;
        String name; 
        int price = 0;
        //Kiểm tra ICode
        do {            
            System.out.print("Enter ICode: ");
            code = s.nextLine();
            if(code.isEmpty()){
            System.out.println("ICode can not be null !");
        }
        } while (code.isEmpty());
        
        //Kiểm tra ItemName
        do {            
            System.out.print("Enter ItemName: ");
            name = s.nextLine();
            if(name.isEmpty()){
            System.out.println("Book title can not be null !");
        }
        } while (name.isEmpty());
        
        //Kiểm tra price
        String temp;
        boolean isNum;
        do {            
            System.out.print("Enter Rate: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if(isNum){
                    price = Integer.parseInt(temp);
                }else{
                    System.out.println("Rate must be number only !");
                }
        } while (!isNum);
        
        String sql = "Insert into Item values ('"+code+"','"+name+"',"+price+")";
        try {
            
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insert successfully");
    }
    
    public void dbUpdate(){
        try {
            String code;
            String name ="";
            int price = 0;
            
            System.out.println("Enter ICode to update: ");
            code = s.nextLine();
            
            String search = "Select ICode from Item where ICode = '"+code+"'";
            
            
            Statement st1 = cnn.createStatement();
            ResultSet r = st1.executeQuery(search);
            
            if(!r.next()){
                System.out.println("Invalid ICode, please try again.");
            }else{
                
                do {            
                    System.out.print("Enter new ItemName: ");
                    name = s.nextLine();
                    if(name.isEmpty()){
                        System.out.println("ItemName can not be null.");
                    }
                } while (name.isEmpty());
                String temp;
                boolean isNum;
                do {            
                    System.out.print("Enter new Rate: ");
                    temp = s.nextLine();
                    isNum = temp.matches("\\d+");
                    if(isNum){
                        price = Integer.parseInt(temp);
                    }else{
                        System.out.println("Rate must be number only.");
                    }
                } while (!isNum);
                
                String sql = "Update Item "
                    + "set ItemName = '"+name+"', Rate = "+price+" "
                    + "where ICode = '"+code+"'";
                Statement st = cnn.createStatement();
                st.executeUpdate(sql);
            
            System.out.println("Update successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dbDelete(){
        try {
            String code;
            
            System.out.println("Enter ICode to update: ");
            code = s.nextLine();
            
            String search = "Select ICode from Item where ICode = '"+code+"'";
            
            
            Statement st1 = cnn.createStatement();
            ResultSet r = st1.executeQuery(search);
            
            if(!r.next()){
                System.out.println("Invalid ICode, please try again.");
            }else{
             
            String sql = "Delete from Item where ICode = '"+code+"'";

            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            
            System.out.println("Delete successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void menu(){
        
        DBTest test1 = new DBTest();
        int choose;
        String ans;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Menu to edit Item table");
            System.out.println("1. Select");
            System.out.println("2. Insert");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Quit");
            
        String temp;
        boolean isNum;
        do {            
            System.out.print("Enter a number: ");
                temp = s.nextLine();
                isNum = temp.matches("\\d+");
                if(isNum){
                    choose = Integer.parseInt(temp);
                    switch (choose){
                case 1:
                    test1.dbSelect();
                    break;
                case 2:
                    test1.dbInsert();
                    break;
                case 3:
                    test1.dbUpdate();
                    break;
                case 4:
                    test1.dbDelete();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter a number again!");
            }
                }else{
                    System.out.println("Please enter a number!");
                }
        } while (!isNum);
                
            System.out.print("Continue (Y/N) ? ");
                ans = s.nextLine();
        }while(ans.equalsIgnoreCase("y"));
        
    }
}
