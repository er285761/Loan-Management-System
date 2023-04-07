package uranus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 * Created by Krista_Sunesis on 12/22/2016.
 */
public class DynamicTable {

    /**
     * declare variables
     */
    private ObservableList<ObservableList> data;

    private TableView tableView;

    public void buildData(){
        data = FXCollections.observableArrayList();

        try{
            /**
             * SQL for selecting data from the database
             */
            String SQL =  "SELECT * FROM `loans_table`";


        }catch(Exception e){}
    }
}
