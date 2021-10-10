package Project.app;

// import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Project.tools.*;

import java.io.IOException;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
// import org.elasticsearch.search.builder.SearchSourceBuilder;
// import org.elasticsearch.action.search.SearchRequest;
// import java.util.Scanner;



@SpringBootApplication

public class Application {
    // private static String[] _args;


    public static void main(String[] args)
        throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException,
    NoSuchProviderException {
        SpringApplication.run(Application.class, args);

        ESManager EsManager = new ESManager();
        RestHighLevelClient HighClient = EsManager.CreateHighLevelClient();
        // RestClient LowLevelClient = EsManager.CreateLowLevelClient(HighClient);
        InfoService infoService = new InfoService(HighClient);
        // IndexService indexService = new IndexService(HighClient);
        System.out.println(ConsoleColors.BLUE_BRIGHT + "Number of Indexes ----> " + 
        ConsoleColors.RESET
        + infoService.CountIndexes());

        
        String request = "filebeat-7.13.4-2021.10.09-000001";

        try
        {
            System.out.println(ConsoleColors.BLUE_BRIGHT + "Indexes ----> " +
            ConsoleColors.RESET
            + infoService.GetIndexName(request));
            System.out.print("\n\n\n");

            System.out.println(ConsoleColors.BLUE_BRIGHT + "All Indexes ----> " +
            ConsoleColors.RESET);
            infoService.ShowAllIndexes();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        catch(JSONException e2)
        {
            e2.printStackTrace();
        }
        
    }

}