package com.gssl;/*
 *
 * @project - apache-beam-bg-project
 * @author - Babu Gumpu , on 02/10/2022
 *
 */

import com.gssl.options.BQETLOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class DataFlowMain {
    public static void main(String[] args) {
        PipelineOptionsFactory.register(BQETLOptions.class);

        /*
         * get the custom options
         */
        BQETLOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(BQETLOptions.class);
        Pipeline pipeline = Pipeline.create(options);


    }
}
