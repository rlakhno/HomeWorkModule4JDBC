package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseQueryService {


    public List<LongestProject> findLongestProjects() throws IOException {
        LongestProject longestProject = new LongestProject();

        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();
            Statement statement = conn.createStatement()){

        Path sqlScriptPath = Paths.get("./src/SQL/find_longest_project.sql");
            List<String> sqlScript = Files.readAllLines(sqlScriptPath);

            for(String script: sqlScript) {
                statement.executeQuery(script);
            }
            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            resultSet = statement.executeQuery(listString);
            while (resultSet.next()) {
                longestProject.setProject_id(resultSet.getInt("project_id"));
                longestProject.setLongest_month(resultSet.getString("longest_month"));
                System.out.format(" %d, %s\n", longestProject.getProject_id(),longestProject.getLongest_month());
            }
            // Clean-up environment
            statement.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }


        return null;

    }


    List<MaxProjectsClient> findMaxProjectClient() throws  IOException {

        MaxProjectsClient maxProjectsClient = new MaxProjectsClient();
                ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();
        Statement statement = conn.createStatement()){

            Path sqlScriptPath = Paths.get("./src/SQL/find_max_projects_client.sql");
            List<String> sqlScript = Files.readAllLines(sqlScriptPath);

            for(String script: sqlScript) {
                statement.executeQuery(script);
            }
            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            resultSet = statement.executeQuery(listString);
            while(resultSet.next()){
                maxProjectsClient.setClient_name(resultSet.getString("client_name"));
                maxProjectsClient.setProject_count(resultSet.getInt("project_count"));
                System.out.format(" %d, %s\n", maxProjectsClient.getProject_count()
                        , maxProjectsClient.getClient_name());
            }
            // Clean-up environment
            statement.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }

        return null;

    }

    List<MaxSalaryWorker> findMaxSalaryWorker() throws  IOException {

        MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();
            Statement statement = conn.createStatement()){

            Path sqlScriptPath = Paths.get("./src/SQL/find_max_salary_worker.sql");
            List<String> sqlScript = Files.readAllLines(sqlScriptPath);

            for(String script: sqlScript) {
                statement.executeQuery(script);
            }
            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            resultSet = statement.executeQuery(listString);
            while(resultSet.next()){
                maxSalaryWorker.setName(resultSet.getString("name"));
                maxSalaryWorker.setMax_salary(resultSet.getInt("max_salary"));

                System.out.format("%d, %s\n", maxSalaryWorker.getMax_salary(), maxSalaryWorker.getName());

            }
            // Clean-up environment
            statement.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }

        return null;

    }
    List<YoungestEldestWorker> findYoungestEldestWorker() throws  IOException {

        YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();
            Statement statement = conn.createStatement()){

            Path sqlScriptPath = Paths.get("./src/SQL/find_youngest_eldest_workers.sql");
            List<String> sqlScript = Files.readAllLines(sqlScriptPath);

            for(String script: sqlScript) {
                statement.executeQuery(script);
            }
            String listString = sqlScript.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            resultSet = statement.executeQuery(listString);
            while(resultSet.next()){
                youngestEldestWorker.setName(resultSet.getString("name"));
                youngestEldestWorker.setBirthday(resultSet.getString("birthday"));
                youngestEldestWorker.setType(resultSet.getString("type"));

                System.out.format(" %s, %s, %s\n", youngestEldestWorker.getType()
                        , youngestEldestWorker.getName(), youngestEldestWorker.getBirthday());

            }
            // Clean-up environment
            statement.close();
            conn.close();

        }catch(SQLException exception){
            exception.printStackTrace();
        }

        return null;

    }

    List<ProjectPrices> printProjectPrices() throws IOException {

        ProjectPrices projectPrices = new ProjectPrices();
        ResultSet resultSet = null;
        try(Connection conn = Database.getInstance().getConnection();
            Statement statement = conn.createStatement()){

            Path sqlScriptPath = Paths.get("./src/SQL/print_project_prices.sql");
            List<String> sqlScript = Files.readAllLines(sqlScriptPath);

            for(String script: sqlScript){
                statement.executeQuery(script);
            }
            String listString = sqlScript.stream().map(String::valueOf).collect(Collectors.joining());
            resultSet = statement.executeQuery(listString);
            while(resultSet.next()){
                projectPrices.setProject_id(resultSet.getInt("project_id"));
                projectPrices.setPrice(resultSet.getInt("price"));
                System.out.format("   %d,     %d\n", projectPrices.getProject_id(), projectPrices.getPrice());
            }

            // Clean-up environment
            statement.close();
            conn.close();


        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

}
