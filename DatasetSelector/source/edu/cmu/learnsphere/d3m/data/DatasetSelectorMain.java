package edu.cmu.learnsphere.d3m.data;

import java.io.File;

import edu.cmu.pslc.datashop.workflows.AbstractComponent;

/**
 * Workflow component: template source for a component
 */
public class DatasetSelectorMain extends AbstractComponent {

	/** Component option (ds_name). */
	String ds_name = null;

    /**
     * Main method.
     * @param args the arguments
     */
    public static void main(String[] args) {

        DatasetSelectorMain tool = new DatasetSelectorMain();
        tool.startComponent(args);
    }

    /**
     * Constructor.
     */
    public DatasetSelectorMain() {
        super();
    }

    @Override
    protected void processOptions() {
        logger.info("Processing Options");

        // The addMetaData* methods make the meta data available to downstream components.
		this.addMetaData("d3m-dataset", 0, META_DATA_LABEL, "label0", 0, null);


	// Add input meta-data (headers) to output file.
	this.addMetaDataFromInput("dataset-list", 0, 0, ".*");

	// Add additional meta-data for each output file.
	this.addMetaData("dataset", 0, META_DATA_LABEL, "label0", 0, null);

    }

    @Override
    protected void parseOptions() {

	if(this.getOptionAsString("ds_name") != null) {
		ds_name = this.getOptionAsString("ds_name");
	}

    }

    /**
     * Processes the input file(s) and option(s) to generate inputs to next component(s).
     */
    @Override
    protected void runComponent() {

	// Run the program...
	File outputDirectory = this.runExternal();


	File outputFile0 = new File(outputDirectory.getAbsolutePath() + "/datasetDoc.tsv");

		this.addOutputFile(outputFile0, 0, 0, "dataset");


        System.out.println(this.getOutput());

    }
}
