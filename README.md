# apache-beam-bg-project
apache-beam-bg-project

mvn compile exec:java -Dexec.mainClass=com.gssl.DataFlowMain -Dexec.args="--project=symbolic-tape-345822 --tempLocation=gs://dataflow_bq_example --runner=BlockingDataflowPipelineRunner"


https://medium.com/bb-tutorials-and-thoughts/how-to-run-a-gcp-dataflow-pipeline-from-local-machine-de4a6a4ff611


mvn compile exec:java -Dexec.mainClass=com.gssl.DataFlowMain --tempLocation=gs://dataflow_bq_example/temp



gcloud config set compute/region europe-west2