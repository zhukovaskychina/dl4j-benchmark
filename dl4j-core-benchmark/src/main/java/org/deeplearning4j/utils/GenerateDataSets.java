package org.deeplearning4j.utils;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;

/**
 * @author raver119@gmail.com
 */
public class GenerateDataSets {

    public static void main(String[] args) throws Exception {

        new File("/tmp/bmd").mkdirs();

        for (int i = 0; i < 200; i++) {
            INDArray features = Nd4j.rand(119, 128, 3, 224, 224);
            INDArray labels = Nd4j.zeros(128, 8644).getColumn(0).assign(1.0f);

            DataSet ds = new DataSet(features, labels);

            ds.save(new File("/tmp/bmd/","bm-train-" + i + ".bin"));
        }
    }
}
