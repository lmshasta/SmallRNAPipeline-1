/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.uio.medisin.bag.ngssmallrna.steps;

import java.util.ArrayList;
import no.uio.medisin.bag.ngssmallrna.pipeline.SampleDataEntry;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

/**
 *
 * @author sr
 */
abstract public class NGSStep {
    
    protected StepInputData             stepInputData   = null;
    protected StepResultData            stepResultData  = null;
    
    protected               String      inFolder        = null;
    protected               String      outFolder       = null;
    
    protected static final  String      FileSeparator   = System.getProperty("file.separator");
    
    abstract void verifyInputData();
    abstract void outputResultData();
    abstract void execute();
    
    
    /**
     * set paths for input and output data folders
     * 
     */
    final void setPaths(){
        
        stepInputData.getInputFolder();
        String projectFolder = stepInputData.getProjectRoot() + System.getProperty("file.separator") + stepInputData.getProjectID();
        projectFolder = projectFolder.replace(FileSeparator + FileSeparator, FileSeparator).trim();
        
        inFolder = projectFolder + FileSeparator + stepInputData.getInputFolder();
        outFolder = projectFolder + FileSeparator + stepInputData.getOutputFolder();
        
    }
    
}
