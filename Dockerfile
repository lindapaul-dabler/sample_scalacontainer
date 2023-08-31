
FROM hseeberger/scala-sbt:8u302_1.5.5_2.13.6


# Set the working directory inside the container
WORKDIR  /usr/src/app

# Copy the Scala application files to the container
COPY samplefile.scala /usr/src/app/samplefile.scala

# Compile the Scala code
#RUN scalac samplefile.scala

# Command to run when the container starts
CMD ["scala", "Main"]


