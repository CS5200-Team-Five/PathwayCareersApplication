//package sponsor.dal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import sponsor.model.Sponsorship;
//
//public class SponsorshipDao {
//    private static SponsorshipDao instance = null;
//    protected ConnectionManager connectionManager;
//
//    protected SponsorshipDao() {
//        connectionManager = new ConnectionManager();
//    }
//
//    public static SponsorshipDao getInstance() {
//        if (instance == null) {
//            instance = new SponsorshipDao();
//        }
//        return instance;
//    }
//
//    public Sponsorship create(Sponsorship sponsorship) throws SQLException {
//        String insertSponsorship = "INSERT INTO Sponsorship(CASE_NUMBER, SPONSORSHIP_TYPE, JOB_TITLE) VALUES(?, ?, ?)";
//        try (Connection connection = connectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(insertSponsorship, PreparedStatement.RETURN_GENERATED_KEYS)) {
//
//            statement.setString(1, sponsorship.getCaseNumber());
//            statement.setString(2, sponsorship.getSponsorshipType());
//            statement.setString(3, sponsorship.getJobTitle());
//            statement.executeUpdate();
//
//            ResultSet resultKey = statement.getGeneratedKeys();
//            int sponsorshipId = -1;
//            if (resultKey.next()) {
//                sponsorshipId = resultKey.getInt(1);
//            }
//            sponsorship.setSponsorshipId(sponsorshipId);
//            return sponsorship;
//        }
//    }
//
//    public Sponsorship getSponsorshipById(int sponsorshipId) throws SQLException {
//        String selectSponsorship = "SELECT * FROM Sponsorship WHERE SPONSORSHIP_ID=?";
//        try (Connection connection = connectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(selectSponsorship)) {
//
//            statement.setInt(1, sponsorshipId);
//            ResultSet results = statement.executeQuery();
//
//            if (results.next()) {
//                String caseNumber = results.getString("CASE_NUMBER");
//                String sponsorshipType = results.getString("SPONSORSHIP_TYPE");
//                String jobTitle = results.getString("JOB_TITLE");
//                return new Sponsorship(sponsorshipId, caseNumber, sponsorshipType, jobTitle);
//            }
//        }
//        return null;
//    }
//
//    public Sponsorship delete(Sponsorship sponsorship) throws SQLException {
//        String deleteSponsorship = "DELETE FROM Sponsorship WHERE SPONSORSHIP_ID=?";
//        try (Connection connection = connectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(deleteSponsorship)) {
//
//            statement.setInt(1, sponsorship.getSponsorshipId());
//            statement.executeUpdate();
//            return null;
//        }
//    }
//}


package sponsor.dal;
import sponsor.model.*;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SponsorshipDao {
    private static SponsorshipDao instance = null;
    protected ConnectionManager connectionManager;

    protected SponsorshipDao() {
        connectionManager = new ConnectionManager();
    }

    public static SponsorshipDao getInstance() {
        if (instance == null) {
            instance = new SponsorshipDao();
        }
        return instance;
    }

    public Sponsorship create(Sponsorship sponsorship) throws SQLException {
        String insertSponsorship = "INSERT INTO Sponsorship(CASE_NUMBER, SPONSORSHIP_TYPE, JOB_TITLE) VALUES(?, ?, ?)";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSponsorship, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, sponsorship.getCaseNumber());
            statement.setString(2, sponsorship.getSponsorshipType());
            statement.setString(3, sponsorship.getJobTitle());
            statement.executeUpdate();

            ResultSet resultKey = statement.getGeneratedKeys();
            int sponsorshipId = -1;
            if (resultKey.next()) {
                sponsorshipId = resultKey.getInt(1);
            }
            sponsorship.setSponsorshipId(sponsorshipId);
            return sponsorship;
        }
    }

    public Sponsorship getSponsorshipById(int sponsorshipId) throws SQLException {
        String selectSponsorship = "SELECT * FROM Sponsorship WHERE SPONSORSHIP_ID=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSponsorship)) {

            statement.setInt(1, sponsorshipId);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                String caseNumber = results.getString("CASE_NUMBER");
                String sponsorshipType = results.getString("SPONSORSHIP_TYPE");
                String jobTitle = results.getString("JOB_TITLE");
                return new Sponsorship(sponsorshipId, caseNumber, sponsorshipType, jobTitle);
            }
        }
        return null;
    }

    public Sponsorship delete(Sponsorship sponsorship) throws SQLException {
        String deleteSponsorship = "DELETE FROM Sponsorship WHERE SPONSORSHIP_ID=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteSponsorship)) {

            statement.setInt(1, sponsorship.getSponsorshipId());
            statement.executeUpdate();
            return null;
        }
    }

    public Sponsorship getSponsorshipByCaseNumber(String caseNumber) throws SQLException {
        String selectSponsorship = "SELECT * FROM Sponsorship WHERE CASE_NUMBER=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSponsorship)) {

            statement.setString(1, caseNumber);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                int sponsorshipId = results.getInt("SPONSORSHIP_ID");
                String sponsorshipType = results.getString("SPONSORSHIP_TYPE");
                String jobTitle = results.getString("JOB_TITLE");
                return new Sponsorship(sponsorshipId, caseNumber, sponsorshipType, jobTitle);
            }
        }
        return null;
    }

    public List<Map<String, Object>> analysis() throws SQLException {
        String querySql = "SELECT \n" +
                "    e.EMPLOYER_NAME,\n" +
                "    e.EMPLOYER_CITY,\n" +
                "    e.EMPLOYER_STATE_PROVINCE,\n" +
                "    COUNT(s.CASE_NUMBER) AS TOTAL_APPLICATIONS,\n" +
                "    SUM(CASE WHEN c.CASE_STATUS = 'CERTIFIED' THEN 1 ELSE 0 END) AS APPROVED_APPLICATIONS,\n" +
                "    ROUND((SUM(CASE WHEN c.CASE_STATUS = 'CERTIFIED' THEN 1 ELSE 0 END) / COUNT(s.CASE_NUMBER)) * 100, 2) AS SUCCESS_RATE_PERCENT\n" +
                "FROM \n" +
                "    Employer e\n" +
                "JOIN \n" +
                "    Job j ON e.EMPLOYER_ID = j.EMPLOYER_ID\n" +
                "JOIN \n" +
                "    Sponsorship s ON j.CASE_NUMBER = s.CASE_NUMBER\n" +
                "JOIN \n" +
                "    cases c ON s.CASE_NUMBER = c.CASE_NUMBER\n" +
                "GROUP BY \n" +
                "    e.EMPLOYER_NAME, e.EMPLOYER_CITY, e.EMPLOYER_STATE_PROVINCE\n" +
                "HAVING \n" +
                "    COUNT(s.CASE_NUMBER) >= 5\n" +
                "ORDER BY \n" +
                "    COUNT(s.CASE_NUMBER) DESC;";
        List<Map<String, Object>> mapList = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySql)) {
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                Map<String, Object> map = new HashMap<>();
                String employerName = results.getString("EMPLOYER_NAME");
                String employerCity = results.getString("EMPLOYER_CITY");
                String employerStateProvince = results.getString("EMPLOYER_STATE_PROVINCE");
                int totalApplications = results.getInt("TOTAL_APPLICATIONS");
                int approvedApplications = results.getInt("APPROVED_APPLICATIONS");
                double successRate = results.getDouble("SUCCESS_RATE_PERCENT");
                map.put("companyName", employerName);
                map.put("location", employerCity + " " + employerStateProvince);
                map.put("totalApplications", totalApplications);
                map.put("approvedApplications", approvedApplications);
                map.put("successRate", successRate);
                mapList.add(map);
            }
            return mapList;
        }
    }
}
