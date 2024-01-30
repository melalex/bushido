function isPalindrome(s: string): boolean {
  let left = 0;
  let right = s.length - 1;

  function isLetter(i: number): boolean {
    const it = s[i];
    return (
      (it >= "A" && it <= "Z") ||
      (it >= "a" && it <= "z") ||
      (it >= "0" && it <= "9")
    );
  }

  function isNotLetter(i: number): boolean {
    return !isLetter(i);
  }

  while (left < right) {
    if (isNotLetter(left)) {
      left++;
    } else if (isNotLetter(right)) {
      right--;
    } else {
      if (s[left].toLowerCase() !== s[right].toLowerCase()) {
        return false;
      }

      left++;
      right--;
    }
  }

  return true;
}

console.log(isPalindrome("aaa"))