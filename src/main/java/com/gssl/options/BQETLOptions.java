package com.gssl.options;/*
 *
 * @project - apache-beam-bg-project
 * @author - Babu Gumpu , on 03/10/2022
 *
 */

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

/**
 * The specific pipeline options for this project.
 */
public interface BQETLOptions extends PipelineOptions {
    @Description("SQL query in standard SQL to pull data from BigQuery")
    String getReadQuery();

    void setReadQuery(String value);

    @Description("Name of the BQ column storing the unique identifier of the row")
    String getReadIdColumn();

    void setReadIdColumn(String value);

}
