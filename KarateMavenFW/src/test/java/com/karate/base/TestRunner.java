package com.karate.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
//import com.intuit.karate.FileUtils;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
//import net.masterthought.cucumber.presentation.PresentationMode;

public class TestRunner {

////******************* Below code for Parallel execution **********//		
	
	@Test
    void testParallel() {
        Results results = Runner.path("classpath:com/karate/base").outputCucumberJson(true).parallel(2);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
        
    }	
	

////************ Below code for Cucumber Reporting **************//
//	
   public static void generateReport(String karateOutputPath) {
	   
	   Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
	   List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
	   jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
	   Configuration config = new Configuration(new File("target"), "Karate API Testing");
//	   // optional configuration - check javadocs for details
//	   //config.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
//	   // do not make scenario failed when step has status SKIPPED
//	   //config.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
	   config.addClassifications("Platform", "Windows");
	   config.addClassifications("Browser", "Chrome");
	   config.addClassifications("Branch", "release/1.0");
	   ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
	   reportBuilder.generateReports();
//	   
//	   
//	   
       }	
	
//******************* Below code for sequential execution **********//	
	
//	@Karate.Test
//	Karate runHelloWorld(){
//		
//		return Karate.run("HelloWorld").relativeTo(getClass());
//	}
//	
//	@Karate.Test
//	Karate runJSONReader(){
//		//To run whole feature file		
//		return Karate.run("JSONReader").relativeTo(getClass());
//	}
//	
//	@Karate.Test
//	Karate runMyWorld(){
//		//To run whole feature file	
//		return Karate.run("MyWorld").relativeTo(getClass());
//	}
//	
//	@Karate.Test
//    Karate testTags1() {
//		//To run specific tags inside feature file	
//        return Karate.run("TestWorld").tags("@SmokeTest").relativeTo(getClass());
//    }
//	
	
//	@Karate.Test
//    Karate testTags2() {
//        return Karate.run("HelloWorld").tags("@RegressionTest").relativeTo(getClass());
//    }
	

}