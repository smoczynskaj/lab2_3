package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Justyna on 25.01.2018.
 */
public class SimilarityFinderTest {

    @Test
    public void areEmptySequencesEqual() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {};

        SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDubler());

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertEquals(BigDecimal.valueOf(result), BigDecimal.valueOf(1.0d));
    }

    @Test
    public void areSequencesIdentical() throws Exception {
        int[] seq1 = {1, 0, 3, 22, 7, 2, 99};
        int[] seq2 = {22, 1, 7, 99, 3, 2, 0};

        SequenceSearcher dubler = new SequenceSearcherDubler(true, true, true, true, true, true, true);

        SimilarityFinder similarityFinder = new SimilarityFinder(dubler);

        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);

        assertEquals(BigDecimal.valueOf(result), BigDecimal.valueOf(1.0d));
    }
}