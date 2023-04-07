package uranus;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.sql.*;

public class function {
    TextField clientName = new TextField();
    TextField email = new TextField();
    TextField phone = new TextField();
    TextField nextOfKin = new TextField();
    TextField gender = new TextField();
    TextField address = new TextField();
    TextField jobOfClient = new TextField();
    TextField photo = new TextField();
    TextField signature = new TextField();
    TextField employer = new TextField();
    TextField company = new TextField();
    TextField location = new TextField();
    TextField businessType = new TextField();
    TextField contact = new TextField();
    TextField salary = new TextField();
    TextField gName = new TextField();
    TextField gPhone = new TextField();
    TextField gEmail = new TextField();
    TextField gAccount = new TextField();
    TextField gAddress = new TextField();
    TextField gGenderOfSalutation = new TextField();
    TextField aNumber = new TextField();
    TextField aName = new TextField();
    TextField aType = new TextField();
    TextField aValue = new TextField();

    Color color;
    TextField lpn=new TextField();
    ChoiceBox _client,loanst;
    TextField lmc=new TextField();
    TextField accs=new TextField();
    TextField lmt=new TextField();
    DatePicker std=new DatePicker();
    DatePicker edt=new DatePicker();
    //TextField loanst=new TextField();
    TextField rate=new TextField();

    Button btAdd,btReset;

    private ObservableList<ObservableList> data;

    private TableView tableView;

    public Label lab(String name){
        Label l=new Label(name);
       return l;
    }


    //database connection statement
    public Connection con(){
        Connection c=null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            String url = "jdbc:mysql://localhost/uranuslms";

            String username = "root";
            String password = "";
            c = DriverManager.getConnection(url, username, password);

        }catch(Exception e){
            System.out.println("An error in the database connection occured:" +e);
        }

        return c;
    }

    //home screen tabpane menu
    public TabPane _tab(){
        TabPane tabs = new TabPane();
        tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab clientTab = new Tab();
        clientTab.setText("Client");
        clientTab.setContent(clientInformation());

        Tab loanTab = new Tab();
        loanTab.setText("Loan");
        loanTab.setContent(loanApplication());

        Tab disbursedLoanTab = new Tab();
        disbursedLoanTab.setText("Disbursed Loan");
        disbursedLoanTab.setContent(disbursed_loans());


        Tab collectionPlanTab = new Tab();
        collectionPlanTab.setText("Collection Plan");
        collectionPlanTab.setContent(collectionPlan());

        Tab reportTab = new Tab();
        reportTab.setText("Report");
        reportTab.setContent(report());

        tabs.getTabs().addAll(clientTab, loanTab, disbursedLoanTab, collectionPlanTab, reportTab);
        //tabs.setBackground(new Colo;
        return  tabs;
    }


//client tab
    public Pane clientInformation() {
       // connect();

        GridPane border = new GridPane();
        border.setAlignment(Pos.CENTER);
        border.setPadding(new Insets(5.5, 12.5, 13.5, 14.5));
        border.setHgap(30.0);
        border.setVgap(30.0);

        /**
         * Place nodes in the pane
         */

        // Personal information
        border.add(new Label("Name Of Client:"), 0, 0);
        border.add(clientName, 1, 0);



        border.add(new Label("Job Of Client:"), 0, 1);
        border.add(jobOfClient, 1, 1);

        border.add(new Label("Next Of Kin:"), 0, 2);
        border.add(nextOfKin, 1, 2);

        border.add(new Label("Gender(client):"), 0, 3);
        border.add(gender, 1, 3);

// Contact information
        border.add(new Label("Address:"), 5, 0);
        border.add(address, 6, 0);

        border.add(new Label("Phone:"), 5, 1);
        border.add(phone, 6, 1);

        border.add(new Label("Email:"), 5, 2);
        border.add(email, 6, 2);

        // Uploads
        border.add(new Label("Photo:"), 5, 9);
        border.add(photo, 6, 9);

        border.add(new Label("Signature:"), 10, 5);
        border.add(signature, 11, 5);

        // Employment Information
        border.add(new Label("Employer:"), 5, 3);
        border.add(employer, 6, 3);

        border.add(new Label("Location:"), 5, 4);
        border.add(location, 6, 4);

        border.add(new Label("Business Type:"), 5, 5);
        border.add(businessType, 6, 5);

        border.add(new Label("Salary Scale:"), 5, 6);
        border.add(salary, 6, 6);

        border.add(new Label("Employer Contact:"), 5, 7);
        border.add(contact, 6, 7);

        border.add(new Label("Company Title:"), 5, 8);
        border.add(company, 6, 8);


        //References and Guarantors
        border.add(new Label("Name(Reference):"), 0, 4);
        border.add(gName, 1, 4);

        border.add(new Label("Phone(Reference):"), 0, 5);
        border.add(gPhone, 1, 5);

        border.add(new Label("Email(Reference):"), 0, 6);
        border.add(gEmail, 1, 6);

        border.add(new Label("Account Number In Bank(Reference):"), 0, 7);
        border.add(gAccount, 1, 7);

        border.add(new Label("Address(Reference):"), 0, 8);
        border.add(gAddress, 1, 8);

        border.add(new Label("Gender Or Salutation(Reference):"), 0, 9);
        border.add(gGenderOfSalutation, 1, 9);


        // Assets
        border.add(new Label("Asset Number:"), 10, 0);
        border.add(aNumber, 11, 0);

        border.add(new Label("Asset Type:"), 10, 1);
        border.add(aType, 11, 1);

        border.add(new Label("Asset Name:"), 10, 2);
        border.add(aName, 11, 2);

        border.add(new Label("Asset Estimated Value:"), 10, 3);
        border.add(aValue, 11, 3);



        Button btAdd = new Button("OK");
        Button btReset = new Button("RESET");
        border.add(btAdd, 10, 7);
        border.add(btReset, 11, 7);
        btAdd.setPrefSize(100,50);
        btReset.setPrefSize(100, 50);
        GridPane.setHalignment(btAdd, HPos.CENTER);
        GridPane.setHalignment(btReset, HPos.CENTER);


        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String  client, em, ph, nextofkin, gen, add, jobofclient, phot,signat, employ,comp,loc, bussType, cont,
                        sal,gNam, gPhon, gEm, gAcc, gAdd, gGenderofSalutation, aNum, aNam, aTyp, aValu;
               // cid=rate.getText();
                client=clientName.getText().toString();
                em=email.getText().toString();
                ph=phone.getText();
                nextofkin=nextOfKin.getText();
                gen=gender.getText().toString();
                add=address.getText();
                jobofclient=jobOfClient.getText().toString();
               phot=photo.getText().toString();
                signat=signature.getText().toString();
                employ=employer.getText().toString();
                comp=company.getText().toString();
                loc=location.getText();
                bussType=businessType.getText();
                cont=contact.getText().toString();
                sal=salary.getText();
                gNam=gName.getText().toString();
                gPhon=gPhone.getText().toString();
                gEm=gEmail.getText().toString();
                gAcc=gAccount.getText().toString();
                gAdd=gAddress.getText().toString();
                gGenderofSalutation=gGenderOfSalutation.getText().toString();
                aNum=aNumber.getText().toString();
                aNam=aName.getText().toString();
                aTyp=aType.getText().toString();
                aValu=aValue.getText();


                String ins_2="insert into client(clientName,email,phone,nextOfKin,gender,address,jobOfClient,photo,"
                        +"signature,employer,company,location, businessType, contact, salary, gName, gPhone, gemail,"
                        +"gAccount, gAddress, gGenderOfSalutation, aNumber, aName, aType, aValue) "+

                        "values('"+client+"','"+em+"','"+ph+"','"+nextofkin+"','"+gen+"','"+add+"','"+jobofclient+"','"+phot+"',"
                        +"'"+signat+"','"+employ+"','"+comp+"','"+loc+"','"+bussType+"','"+cont+"','"+sal+"','"+gNam+"'," +
                        "'"+gPhon+"','"+gEm+"','"+gAcc+"','"+gAdd+"','"+gGenderofSalutation+"','"+aNum+"','"+aNam+"','"+aTyp+"'," +
                        "'"+aValu+"')";
                try {
                    Statement st2 = con().createStatement();
                    st2.executeUpdate(ins_2);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



        return border;
    }

    //loan tab
    public Pane loanApplication() {

        GridPane border1 = new GridPane();
        border1.setAlignment(Pos.CENTER);
        border1.setPadding(new Insets(5.5, 12.5, 13.5, 14.5));
        border1.setHgap(30.0);
        border1.setVgap(30.0);



        // Loan Information
        border1.add(new Label("Loan Product Name:"), 0, 0);
        border1.add(lpn, 1, 0);




        border1.add(new Label("Client Name:"), 0, 1);
        ObservableList list=FXCollections.observableArrayList();
        try {
            String q = "select clientName from client order by clientName ASC limit 200";
            Statement st = con().createStatement();
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
                String _cname=rs.getString("clientName");
                list.add(_cname);
            }

        }catch(Exception e){

        }

        _client=ChoiceBoxBuilder.create().items(list).build();

        border1.add(_client, 1, 1);

        border1.add(new Label("Loan Account :"), 0, 2);
        border1.add(lmc, 1, 2);

        border1.add(new Label("Account State:"), 0, 3);
        border1.add(accs, 1, 3);


// Contact information
        border1.add(new Label("Loan Amount:"), 5, 0);
        border1.add(lmt, 6, 0);


        border1.add(new Label("Start Date:"), 5, 1);
        border1.add(std, 6, 1);


        border1.add(new Label("End Date:"), 5, 2);
        border1.add(edt, 6, 2);

        border1.add(new Label("Loan status:"), 5, 3);
        ObservableList list1=FXCollections.observableArrayList("pending","disbursed","rejected");
        loanst=ChoiceBoxBuilder.create().items(list1).build();

        border1.add(loanst, 6, 3);

        border1.add(new Label("Interest Rate:"), 5, 4);
        border1.add(rate, 6, 4);


        btAdd = new Button("OK");
        btReset = new Button("RESET");
        border1.add(btAdd, 1, 6);
        border1.add(btReset, 5, 6);
        btAdd.setPrefSize(100,40);
        btReset.setPrefSize(100, 40);
        GridPane.setHalignment(btAdd, HPos.CENTER);
        GridPane.setHalignment(btReset, HPos.CENTER);

        btAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String rat,loanstatus,enddate,startdate, loanamount,loan_acc,acc_state,client_name,loan_product;
                rat=rate.getText();
                loanstatus=loanst.getValue().toString();
                loanamount=lmt.getText().toString();
                loan_acc=lmc.getText();
                acc_state=accs.getText();
                client_name=_client.getValue().toString();
                loan_product=lpn.getText();
                enddate=edt.getValue().toString();
                startdate=std.getValue().toString();

                String ins_l="insert into loans_table(loan_product_name,name,amount,acc_state,account,start,end,interest,status) "+
                        "values('"+loan_product+"','"+client_name+"','"+loanamount+"','"+acc_state+"','"+loan_acc+"','"+startdate+"','"+enddate+"','"+rat+"','"+loanstatus+"')";
                try {
                    Statement st2 = con().createStatement();
                    st2.executeUpdate(ins_l);

                }catch (Exception e){
                    e.printStackTrace();
                }
                rate.setText("");
                loanst.setValue("");
                lmt.setText("");
                lmc.setText(""); accs.setText(""); _client.setValue(""); lpn.setText("");

                Label resp_=new Label("Record added successful");
                resp_.setTextFill(color.web("#9acd3c"));
                border1.add(resp_,1,8);

            }
        });


        return border1;

    }


    //disbursed loans
    public GridPane disbursedLoan(){

        GridPane border2 =new GridPane();

        data = FXCollections.observableArrayList();

        String displayTable = "SELECT * FROM loans_table";

        try {
            Statement st2 = con().createStatement();
//            st2.executeUpdate(displayTable);

            ResultSet rs = st2.executeQuery(displayTable);
            /**
             * Table column added dynamically
             */
            for(int i = 0;i<rs.getMetaData().getColumnCount();i++){
                /**
                 * We are using non property style for making dynamic table
                 */
                final int j = i;

                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));

                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
                    @Override
                    public ObservableValue call(TableColumn.CellDataFeatures param) {
                        return new SimpleStringProperty(param.getValue().toString());
                    }
                });

                tableView.getColumns().addAll(col);

                System.out.println("Column ["+i+"]");
            }

            /**
             * Data added to ObservableList
             */
            while(rs.next()){
                //iterate row
                ObservableList<String> row = FXCollections.observableArrayList();

                for(int i = 1;i<rs.getMetaData().getColumnCount();i++){
                    /**
                     * Iterate column
                     */
                    row.add(rs.getString(i));
                }

                System.out.println("Row[1] added " + row);
                data.add(row);
            }

            /**
             * Finally added to TableView
             */
            tableView.setItems(data);
        }catch (Exception e){
            e.printStackTrace();

            System.out.println("Error on Building Data");
        }



        return border2;

    }

    //collection plan
    public Pane collectionPlan(){

        GridPane border3 = new GridPane();


        return border3;

    }

    public Pane report(){

        GridPane border4 = new GridPane();


        return border4;

    }

    public Pane disbursed_loans(){
        Pane p=new Pane();
        ObservableList loan_list=FXCollections.observableArrayList();

        String _li="select * from  loans_table order by status ASC";

        try {
            Statement st3 = con().createStatement();
            ResultSet rs_=st3.executeQuery(_li);

            while(rs_.next()){
                String  lr= rs_.getString("name")+' '+rs_.getString("amount")+" " +rs_.getString("account");

                loan_list.add(lr);


            }
        }catch(Exception e){e.printStackTrace();}

        ListView listview=new ListView(loan_list);


        Label title=new Label("Loans Recorded");
        p.getChildren().addAll(listview);
        return p;
    }



}
