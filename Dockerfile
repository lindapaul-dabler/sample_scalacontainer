FROM hseeberger/scala-sbt:8u302_1.5.5_2.13.6
WORKDIR /usr/src/app
RUN pip install python
RUN pip install boto3
COPY base_requirements.txt ./
COPY files_copy.py ./
COPY send_status.py ./
COPY run.sh ./
RUN apt-get install --no-cache-dir -r base_requirements.txt
RUN chmod +x run.sh
CMD ["scalac","samplefile.scala"]
CMD ./run.sh