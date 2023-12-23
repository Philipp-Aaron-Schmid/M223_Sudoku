package com.example.demo;

import com.model.Challenge;
import com.model.Play;
import com.service.Scorer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ScorerTest {

    @Mock
    private Challenge mockChallenge;

    @Mock
    private Play mockPlay;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateScore_AllCharactersMatch() {
        // All characters match, perfect score
        String playSet = "1".repeat(81); // 81 characters
        String challengeSet = "1".repeat(81); // 81 characters
        when(mockPlay.getPlaySet()).thenReturn(playSet);
        when(mockChallenge.getChallangeSet()).thenReturn(challengeSet);

        Scorer.calculateScoreAndSet(mockChallenge, mockPlay);

        assertEquals(0, mockPlay.getPlayScore());
        assertEquals("111111111111111111111111111111111111111111111111111111111111111111111111111111111111", mockPlay.getPlaysScoreSet());
    }

    @Test
    public void testCalculateScore_NoCharactersMatch() {
        // No characters match
        String playSet = "987654321987654321987654321987654321987654321987654321987654321987654321987654321987"; // 81 characters
        String challengeSet = "123456789123456789123456789123456789123456789123456789123456789123456789123456789123"; // 81 characters
        when(mockPlay.getPlaySet()).thenReturn(playSet);
        when(mockChallenge.getChallangeSet()).thenReturn(challengeSet);

        Scorer.calculateScoreAndSet(mockChallenge, mockPlay);

        assertEquals(81, mockPlay.getPlayScore());
        assertEquals("222222222222222222222222222222222222222222222222222222222222222222222222222222222222", mockPlay.getPlaysScoreSet());
    }

    @Test
    public void testCalculateScore_PartialMatchNoDuplicates() {
        // Partial match, no duplicates
        String playSet = "123456789234567891345678912456789123567891234678912345789123456891234567912345678912"; // 81 characters
        String challengeSet = "123456789123456789123456789123456789123456789123456789123456789123456789123456789123"; // 81 characters
        when(mockPlay.getPlaySet()).thenReturn(playSet);
        when(mockChallenge.getChallangeSet()).thenReturn(challengeSet);

        Scorer.calculateScoreAndSet(mockChallenge, mockPlay);

        // Assuming 9 mismatches
        assertEquals(9, mockPlay.getPlayScore());
        // Update the expectedScoreSet string according to the mismatches in playSet
        String expectedScoreSet = "111111111222222222111111111111111111111111111111111111111111111111111111111111111"; // Example
        assertEquals(expectedScoreSet, mockPlay.getPlaysScoreSet());
    }

    @Test
    public void testCalculateScore_PartialMatchWithDuplicates() {
        // Partial match with duplicates
        String playSet = "123451234512345123451234512345123451234512345123451234512345123451234512345123451"; // 81 characters
        String challengeSet = "123456789123456789123456789123456789123456789123456789123456789123456789123456789123"; // 81 characters
        when(mockPlay.getPlaySet()).thenReturn(playSet);
        when(mockChallenge.getChallangeSet()).thenReturn(challengeSet);

        Scorer.calculateScoreAndSet(mockChallenge, mockPlay);

        // Update the expectedScore and expectedScoreSet according to the test data
        int expectedScore = 1;
        String expectedScoreSet = "123456789123456789123456789123456789123456789123456789123456789123456789123456789123";
        assertEquals(expectedScore, mockPlay.getPlayScore());
        assertEquals(expectedScoreSet, mockPlay.getPlaysScoreSet());
    }

    // Additional test cases...
}