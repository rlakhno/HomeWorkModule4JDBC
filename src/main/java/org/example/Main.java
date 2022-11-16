package org.example;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
/*

        System.out.println("\n--- Longest Project ---\n\nID   MONTH ");
        List<LongestProject>longestProject = new DatabaseQueryService().findLongestProjects();
*/

/*

        System.out.println("\n--- Max Projects Client ---\n\nCount  Name ");
        List<MaxProjectsClient>maxProjectsClients = new DatabaseQueryService().findMaxProjectClient();
*/

/*

        System.out.println("\n--- Max Salary Worker ---\n\nMaxSalary  Name ");
        List<MaxSalaryWorker> maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
*/

/*

        System.out.println("\n--- Youngest - Eldest Worker ---\n\n TYPE     NAME   BIRTHDAY ");
        List<YoungestEldestWorker> youngestEldestWorker = new DatabaseQueryService().findYoungestEldestWorker();

*/


        System.out.println("\n--- Project Prices ---\n\nPROJECT#  PRICE ");
        List<ProjectPrices> projectPrices = new DatabaseQueryService().printProjectPrices();




    /*    Statement statement = null;
        Connection conn = Database.getInstance().getConnection();
        System.out.println("connection... " + conn);
        statement = conn.createStatement();
        Path sqlScriptPath = Paths.get("./src/SQL/find_longest_project.sql");
        List<String> sqlScript = Files.readAllLines(sqlScriptPath);

        for(String script: sqlScript) {
            statement.executeQuery(script);
            System.out.println("script... "+ script);
        }
        String listString = sqlScript.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("New string... " + listString);

        ResultSet resultSet = statement.executeQuery(listString);

        System.out.println("------------------------------");
        System.out.println("project_id  |   longest month ");
        System.out.println("------------------------------");
        while (resultSet.next())
        {
//            int id = resultSet.getInt("id");
            int project_id = resultSet.getInt("project_id");
            String longest_month = resultSet.getString("longest_month");
//            Date dateCreated = rs.getDate("date_created");
//            boolean isAdmin = rs.getBoolean("is_admin");
//            int numPoints = rs.getInt("num_points");


            System.out.println("    " + project_id + "       |    " + longest_month);
            System.out.println("------------------------------");
//            System.out.println("project_id ->  " + project_id + "    longest month ->  " + longest_month);
*//*            System.out.println(" ");
            // print the results
            System.out.format(" %s, %s\n", project_id, monthDiff);*//*
        }

*//*
        //STEP 3: Execute a query
        System.out.println("Creating table in given database...");
                statement = conn.createStatement();
*//**//*        String sql =  "CREATE TABLE   REGISTRATION " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";
        String sql = "drop TABLE   REGISTRATION";*//**//*
        String sql = "drop TABLE   worker";
//        String sql = "CREATE TABLE worker ( worker_id SERIAL PRIMARY KEY, name VARCHAR(1000) NOT NULL, birthday DATE CHECK ( birthday > '1900-01-01') NOT NULL, level VARCHAR CHECK ( level IN ('Trainee', 'Junior', 'Middle', 'Senior')), salary INT CHECK (99 < salary AND salary < 100001) NOT NULL);";
        statement.executeUpdate(sql);
        System.out.println("Created table in given database...");*//*

        // STEP 4: Clean-up environment
        statement.close();
        conn.close();
        System.out.println("connection is closed    ");*/

    }


}