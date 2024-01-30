function lengthOfLastWord(s: string): number {
  let begin = 0;
  let end = s.length - 1;

  for (let i = s.length - 1; i >= 0; i--) {
    const it = s[i];

    if (it !== " ") {
      end = i;
      break;
    }
  }

  for (let i = end; i >= 0; i--) {
    const it = s[i];

    if (it === " ") {
      begin = i + 1;
      break;
    }
  }

  return end - begin + 1;
}
