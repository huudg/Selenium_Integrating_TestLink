package Connection;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.Attachment;
import br.eti.kinoshita.testlinkjavaapi.model.Execution;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;


public class testlinkAPI {
	static String url = "http://localhost/testlink_1_9_20/lib/api/xmlrpc/v1/xmlrpc.php";
    static String devKey = "555beb374cb296b7e051a2796ff81353";
    static TestLinkAPI api = null;
    static URL testlinkURL = null;
   
    static Execution ex;
    static int id;
   
    
    public static void attachmentImage(String image, int id, String filename) {
    	try     {
    	        testlinkURL = new URL(url);
    	} catch ( MalformedURLException mue )   {
    	        mue.printStackTrace( System.err );
    	        System.exit(-1);
    	}

    	try     {
    	        api = new TestLinkAPI(testlinkURL, devKey);
    	} catch( TestLinkAPIException te) {
    	        te.printStackTrace( System.err );
    	        System.exit(-1);
    	}
    	File attachmentFile = new File(image);        
        String fileContent = null;
        
        try {
                byte[] byteArray = FileUtils.readFileToByteArray(attachmentFile);
        fileContent = new String(Base64.encodeBase64(byteArray));
        } catch (IOException e) {
                e.printStackTrace( System.err );
                System.exit(-1);
        }
        //ex = api.getLastExecutionResult(1, 1, "", null, "", 1, "Build01", null);
        //id = ex.getId();
        Attachment attachment =  api.uploadExecutionAttachment(
                id, //executionId 
                "title", //title 
                "description", //description  
                filename + System.currentTimeMillis()+".jpg", //fileName 
                "image/jpg", //fileType
                fileContent); //content
        
        System.out.println("Attachment uploaded");
    }
}
