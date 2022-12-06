
# Build from source code

```bash
./gradlew build
```

# Start MongoDB

```bash
docker run --name mongodb -v ${PWD}/mongodb:/data/db -d -p 27017:27017 mongo
```

# Import OpenAPI specifications, semantic types and alignment into MongoDB


```bash
java -cp ./build/libs/de.upb.dbis.baas.jar de.upb.dbis.baas.evaluation.Evaluation
```


Open Project Properties
Go to the page "Java Compiler" 
Check the option "Use compliance level from execution environment"