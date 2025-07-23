package com.example.user.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StringUtilService {
    public Set<String> uniquePermutations(String input) {
        Set<String> result = new HashSet<>();
        permute(input.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] arr, int l, Set<String> result) {
        if (l == arr.length - 1) {
            result.add(new String(arr));
        } else {
            Set<Character> swapped = new HashSet<>();
            for (int i = l; i < arr.length; i++) {
                if (swapped.add(arr[i])) {
                    swap(arr, l, i);
                    permute(arr, l + 1, result);
                    swap(arr, l, i);
                }
            }
        }
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}