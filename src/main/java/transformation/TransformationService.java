package transformation;

import pojo.EncodingInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransformationService {

    /**
     * Get Transformation sequence from file
     * @return Transformation sequence
     */
    public List<String> getTransformationSequenceFromFileSystem() {
        String transformationSequence;
        if(System.getenv("TRANSFORMATION_FILE") == null) {
            transformationSequence = "sampleFiles/encoding.txt";
        } else {
            transformationSequence = System.getenv("TRANSFORMATION_FILE");
        }

        //read file into stream, try-with-resources
        StringBuilder sb = new StringBuilder();

        //Assume that encoding string will be small
        try (Stream<String> stream = Files.lines(Paths.get(transformationSequence))) {

            stream.forEach(sb::append);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList(sb.toString().replaceAll("\\s+","").split(","));
    }


    public List<EncodingInfo> getEncodingInfos(List<String> transformSequence) {
        List<EncodingInfo> encodingInfos = new ArrayList<>();
        transformSequence.forEach(encodingTecnique -> {
            encodingInfos.add(EncodingInfo.getInstance(encodingTecnique));
        });
        return encodingInfos;
    }

}
