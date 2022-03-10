rm -rf ./target/generated-sources/ws
mkdir -p ./target/generated-sources/ws
wsimport -d ./target/generated-sources/ws -p ru.vlapin.trainings.integrationtraining.common.wsdl.client -keep http://localhost:1212/hello\?wsdl
rm -rf ./target/generated-sources/ws/ru/vlapin/trainings/integrationtraining/common/wsdl/client/*.class
