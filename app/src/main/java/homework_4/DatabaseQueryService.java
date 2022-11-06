package homework_4;

import ForSQL_Query.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class DatabaseQueryService {
    public DatabaseQueryService(){
    }

    public List<MaxSalaryWorker> find_max_salary_worker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<MaxSalaryWorker>();
            try (Statement st = homework_4.Database.getInstance().getConnection().createStatement()){

            try {
                String initDbFilename = "./sql/find/find_max_salary_worker.sql";
                String sql = String.join(
                        "\n",
                        Files.readAllLines(Paths.get(initDbFilename)));

                try (ResultSet rs = st.executeQuery(sql)){
                    if(rs.next()){
                        String name = rs.getString("name");
                        int salary = rs.getInt("salary");

                        maxSalaryWorkers.add(new MaxSalaryWorker(name,salary));
                        return maxSalaryWorkers;
                    } else {
                        System.out.println("Not found!");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
            return null;
    }

    public List<MaxProjectCountClient> find_max_projects_client(){
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<MaxProjectCountClient>();

        try (Statement st = homework_4.Database.getInstance().getConnection().createStatement()){

            try {
                String initDbFilename = "./sql/find/find_max_projects_client.sql";
                String sql = String.join(
                        "\n",
                        Files.readAllLines(Paths.get(initDbFilename)));

                try (ResultSet rs = st.executeQuery(sql)){
                    if(rs.next()){
                        String name = rs.getString("name");
                        int projectCount = rs.getInt("PROJECT_COUNT");

                        maxProjectCountClients.add(new MaxProjectCountClient(name,projectCount));

                        return maxProjectCountClients;
                    } else {
                        System.out.println("Not found!");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<PrintProjectPrices> print_project_prices(){
        List<PrintProjectPrices> printProjectPrices = new ArrayList<PrintProjectPrices>();

        try (Statement st = homework_4.Database.getInstance().getConnection().createStatement()){

            try {
                String initDbFilename = "./sql/find/print_project_prices.sql";
                String sql = String.join(
                        "\n",
                        Files.readAllLines(Paths.get(initDbFilename)));

                try (ResultSet rs = st.executeQuery(sql)){
                    while (rs.next()) {
                        long id = rs.getLong("id");
                        int price = rs.getInt("price");

                        printProjectPrices.add(new PrintProjectPrices(id, price));
                    }

                    return printProjectPrices;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<YoungestEldestWorkers> find_youngest_eldest_workers(){
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<YoungestEldestWorkers>();

        try (Statement st = homework_4.Database.getInstance().getConnection().createStatement()){

            try {
                String initDbFilename = "./sql/find/find_youngest_eldest_workers.sql";
                String sql = String.join(
                        "\n",
                        Files.readAllLines(Paths.get(initDbFilename)));

                try (ResultSet rs = st.executeQuery(sql)){
                    while (rs.next()) {
                        String type = rs.getString("'TYPE'");
                        String name = rs.getString("NAME");
                        LocalDate birthday = rs.getDate("BIRTHDAY").toLocalDate();
//                        String birthday = rs.getString("BIRTHDAY");

                        youngestEldestWorkers.add(new YoungestEldestWorkers(type,name,birthday));
                    }

                    return youngestEldestWorkers;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public List<LongestProject> find_longest_project(){
        List<LongestProject> longestProjects = new ArrayList<LongestProject>();

        try (Statement st = homework_4.Database.getInstance().getConnection().createStatement()){

            try {
                String initDbFilename = "./sql/find/find_longest_project.sql";
                String sql = String.join(
                        "\n",
                        Files.readAllLines(Paths.get(initDbFilename)));

                try (ResultSet rs = st.executeQuery(sql)){
                    while (rs.next()) {
                        long id = rs.getLong("id");
                        int month_count = rs.getInt("month_count");

                        longestProjects.add(new LongestProject(id,month_count));
                    }

                    return longestProjects;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
