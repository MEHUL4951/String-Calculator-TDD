# 🧪 TDD: String Calculator Implementation (Java)

This project demonstrates a step-by-step **Test-Driven Development (TDD)** approach to building a `StringCalculator` using the Red-Green-Refactor cycle. It uses a clean, incremental workflow with test case screenshots showing both failing and passing stages.

---

## ✅ Test Cases and Development Flow

### 1. ✅ Empty String Should Return 0

- **Failing Test:**  
  ![TestCase1_fail](https://github.com/user-attachments/assets/8b5a86fe-f13c-4b3c-a708-4d06b725551f)

- **Passing Test:**  
  ![TestCase1_Pass](https://github.com/user-attachments/assets/93ee8c0f-1177-4641-a059-97350df51d60)

---

### 2. ✅ One or Two Numbers Return Their Sum

- **Failing Test:**  
  ![TestCase2_fail](https://github.com/user-attachments/assets/83831ee1-3031-4252-a262-07a683a037c1)  
  ![test_case3_fails](https://github.com/user-attachments/assets/36768f7f-4cc8-43fb-84e9-6799bf5dceb5)

- **Passing Test:**  
  ![Test_case2_Pass](https://github.com/user-attachments/assets/53091f3d-3b1e-467b-a89c-163e87c478f4)

---

### 3. ✅ Handle Newline as Delimiter

- **Failing Test:**  
  *(Not captured or skipped)*

- **Passing Test:**  
  ![testCase3_pass](TDD/testCase3_pass.png)

---

### 4. ✅ Support Unknown Amount of Numbers

- **Passing Test:**  
  ![testCase4_pass](TDD/testCase4_pass.png)

---

### 5. ✅ Support Custom Single-Character Delimiter (e.g. `//;\n1;2`)

- **Passing Test:**  
  ![testCase5_passs](TDD/testCase5_passs.png)

---

### 6. ✅ Negative Numbers Throw Exception With All Negatives Listed

- **Failing Test:**  
  ![test_case6_fail](TDD/test_case6_fail.png)

- **Passing Test:**  
  ![test_case6_pass](TDD/test_case6_pass.png)

---

### 7. ✅ Count How Many Times `Add()` is Called

- **Failing Test:**  
  ![test_case7_fail](TDD/test_case7_fail.png)

- **Passing Test:**  
  ![test_case7_pass](TDD/test_case7_pass.png)

---

### 8. ✅ Numbers Greater Than 1000 are Ignored

- **Passing Test:**  
  ![test_case8_pass](TDD/test_case8_pass.png)

---

### 9. ✅ Custom Delimiters of Any Length (e.g. `//[***]\n1***2***3`)

- **Passing Test:**  
  ![test_case9_pass](TDD/test_case9_pass.png)

---

### 10. ✅ Multiple Delimiters (e.g. `//[*][%]\n1*2%3`)

- **Failing Test:**  
  ![test_case10_fail](TDD/test_case10_fail.png)

- **Passing Test:**  
  ![test10_pass](TDD/test10_pass.png)

---

### 11. ✅ Multiple Multi-Character Delimiters (e.g. `//[##][!!]\n4##5!!6`)

- **Failing Test:**  
  ![testCase11_fail](TDD/testCase11_fail.png)

- **Passing Test:**  
  ![test_case11_pass](TDD/test_case11_pass.png)

---

### 12. ✅ Add Event: `AddOccured(string input, int result)` *(C# Only)*

- **Failing Test:**  
  ![testCase12_fails](TDD/testCase12_fails.png)

- **Passing Test:**  
  ![test_12_pass](TDD/test_12_pass.png)

---

## 🔄 TDD Cycle Used

Each functionality followed this Red-Green-Refactor workflow:

1. 🔴 **Red**: Write a failing test that describes the expected behavior.
2. 🟢 **Green**: Implement the simplest logic to make the test pass.
3. 🔵 **Refactor**: Clean up and optimize the code without changing behavior.

---

## 📸 Screenshot Directory

All screenshots are stored in the `/TDD/` directory:
