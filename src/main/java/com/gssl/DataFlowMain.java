package com.gssl;/*
 *
 * @project - apache-beam-bg-project
 * @author - Babu Gumpu , on 02/10/2022
 *
 */

import com.google.api.services.bigquery.model.TableRow;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;

import static org.apache.beam.sdk.io.TextIO.read;

public class DataFlowMain {
    public static void main(String[] args) {

        String masterInstrumentTableSpec = "symbolic-tape-345822.instrument_rating.master_instrument_rating";
        String rawInstrumentTableSpec = "symbolic-tape-345822.instrument_rating.raw_instrument_rating";
        String exceptionInstrumentTableSpec = "symbolic-tape-345822.instrument_rating.exception_instrument_rating";

        String project = "symbolic-tape-345822";
        String dataset = "instrument_rating";
        String masterInstrumentTable = "master_instrument_rating";

        //Google Storage Bucket Input
        String masterInstrumentFeed = "gs://dataflow_bq_example/master_instrument_rating_input.csv";

        // Start by defining the options for the pipeline.
        PipelineOptions options = PipelineOptionsFactory.create();

        //options.setTempLocation("gs://dataflow_bq_example/temp");
        options.setTempLocation("gs://gssl-bucket-europe-west2/temp");

        // Then create the pipeline.
        Pipeline pipeline = Pipeline.create(options);

        //Reading Data Into Your PCollection
        PCollection<String> pCollection = pipeline.apply("ReadLines", read().from(masterInstrumentFeed));

        PCollection<TableRow> masterInsRating = pipeline.apply(
                BigQueryIO.readTableRows().from("symbolic-tape-345822.instrument_rating.master_instrument_rating"));

        System.out.println("About to run!");

        pipeline.run().waitUntilFinish();
        System.out.println(pCollection.isBounded());
        System.out.println(pCollection.toString());

        System.out.println("Run Complete");


    }
}
