
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shogun
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 */
@WebServlet(urlPatterns = {"/Scores"})
public class Scores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Scores</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Scores at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private Connection getConnection() throws SQLException {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection con
                = DriverManager
                .getConnection(
                        "jdbc:"
                        + "sqlserver://LENOVO-PC\\DAVID;"
                        + "databaseName=FlappyBird;"
                        + "user=flappybird;password=flappybird;");
        return con;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String scoreId = request.getParameter("ScoreId");
        if (scoreId == null) {
            doGetAll(request, response);
        } else if (scoreId.equals("")) {
            doGetAll(request, response);
        } else {
            doGetSingle(scoreId, request, response);
        }
    }

    protected void doGetSingle(String ScoreId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection con = getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs
                    = stmt.executeQuery(
                            "SELECT ScoreId, Username, Score, TimeStamp"
                            + "FROM dbo.Scores"
                            + "WHERE ScoreId - " + ScoreId);
            rs.next();

            ScoreViewModel viewModel = new ScoreViewModel();
            viewModel.username = rs.getString(2);
            viewModel.score = rs.getString(3);

            JsonWriter writer
                    = new JsonWriter(response.getWriter());
            Gson gson = new Gson();
            gson.toJson(
                    viewModel, ScoreViewModel.class, writer
            );

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGetAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PrintWriter writer = response.getWriter();

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            writer.print("[");
            try {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
            }

            //apertura DB
            //writer.println("Connessione Stabilita");
            Connection con = getConnection();
            Statement stmt
                    = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ScoreID, Username, Score, TimeStamp FROM dbo.Scores");

            boolean first = true;
            while (true) {
                if (!rs.next()) {
                    break;
                }
                int scoreId = rs.getInt(1);
                String username = rs.getString(2);
                String score = rs.getString(3);
                String timestamp = rs.getString(4);
                

                //leggi riga
                if (first) {
                    first = false;
                } else {
                    writer.println(",");
                }

                writer.print("{");
                writer.printf(" \"score_id\": \"%s\"	", scoreId);
                writer.printf(", \"username\": \"%s\"	", username);
                writer.printf(", \"score\": \"%s\"", score);
                writer.printf(", \"timestamp\": \"%s\"", timestamp);
                writer.print(" }");
            }
            //chiudi
            con.close();

            //chiudi connessione
            writer.println("]");
        } catch (SQLException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter writer = response.getWriter();

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            writer.print("[");
            try {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
            }

            //apertura DB
            //writer.println("Connessione Stabilita");
            Connection con = getConnection();
            Statement stmt
                    = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Username, Score, TimeStamp FROM dbo.Classified");

            boolean first = true;
            while (true) {
                if (!rs.next()) {
                    break;
                }
                String username = rs.getString(1);
                String score = rs.getString(2);
                String timestamp = rs.getString(3);
                

                //leggi riga
                if (first) {
                    first = false;
                } else {
                    writer.println(",");
                }

                writer.print("{");
                writer.printf(" \"username\": \"%s\"	", username);
                writer.printf(", \"score\": \"%s\"", score);
                writer.printf(", \"timestamp\": \"%s\"", timestamp);
                writer.print(" }");
            }
            //chiudi
            con.close();

            //chiudi connessione
            writer.println("]");
        } catch (SQLException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        BufferedReader reader = request.getReader();

        Gson gson = new Gson();
        ScoreViewModel scores
                    = (ScoreViewModel) gson.fromJson(reader, ScoreViewModel.class); //in questo modo si legge lo stream in ingresso e restituisce ContattoViewModel

        try {
            try {
                Class
                        .forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                        .newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }

            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sql
                    = "INSERT INTO dbo.Scores (Username, Score, TimeStamp)"
                    + "VALUES ("
                    + "'" + scores.username + "'"
                    + ", " + scores.score
                    + ",  GetDate()"
                    + ")";

            stmt.execute(sql); //esegue la query

            JsonWriter writer
                    = new JsonWriter(response.getWriter());

            gson.toJson(
                    Risposta.OK, Risposta.class, writer);

            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
