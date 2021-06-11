import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.columns.Column;
import joinery.DataFrame;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        //reading the file using Table
        Table Titanic_data;
        String datapath = "D:\\train.csv";
        Titanic_data = Table.createFromCsv(datapath);
        List<Column> datastructure = Titanic_data.columns();
        System.out.print(datastructure + "\n");
        //System.out.print(Titanic_data.summary());

        //some infromation from the table
        double Fare = Titanic_data.nCol("Fare").mean();
        System.out.print("the average of the fare is = ");
        System.out.print(Fare);
        int oldest = (int) Titanic_data.nCol("Age").max();
        System.out.print("\nthe oldest person on the ship was : " + oldest + " years old");
        int classes = Titanic_data.nCol("Pclass").countUnique();
        System.out.print("\nthe passenger classes were divided into " + classes + " classes");

        
        read_join();

    }
    public static void read_join () throws IOException{
        //reading using joinery
        DataFrame<Object> df = DataFrame.readCsv("D:\\surveys.csv");
        List<Object> col = df.col("record_id");
        System.out.println(col.size());

    }
}
