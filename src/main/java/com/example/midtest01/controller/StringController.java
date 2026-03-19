package com.example.midtest01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/string")
@CrossOrigin
public class StringController {

  // 1. Reverse String
  @GetMapping("/reverse")
  public String reverseString(@RequestParam String input) {
    if (input == null) return "";
    return new StringBuilder(input).reverse().toString();
  }

  // 2. Palindrome Check
  @GetMapping("/palindrome")
  public String checkPalindrome(@RequestParam String input) {
    if (input == null) return "Not a palindrome";
    String reversed = new StringBuilder(input).reverse().toString();
    if (input.equalsIgnoreCase(reversed)) {
      return input + " is a palindrome";
    } else {
      return input + " is not a palindrome";
    }
  }

  // 3. Remove Duplicates (keep first occurrence)
  @GetMapping("/unique")
  public String removeDuplicates(@RequestParam String input) {
    if (input == null) return "";
    Set<Character> chars = new LinkedHashSet<>();
    for (char c : input.toCharArray()) {
      chars.add(c);
    }
    StringBuilder sb = new StringBuilder();
    for (Character character : chars) {
      sb.append(character);
    }
    return sb.toString();
  }

  // 4. Concat and Trim
  @GetMapping("/concat")
  public String concatAndTrim(@RequestParam String s1, @RequestParam String s2) {
    if (s1 == null || s2 == null) return "";
    
    int len1 = s1.length();
    int len2 = s2.length();
    
    if (len1 > len2) {
      s1 = s1.substring(len1 - len2);
    } else if (len2 > len1) {
      s2 = s2.substring(len2 - len1);
    }
    
    return s1 + s2;
  }
}
