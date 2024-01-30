function longestCommonPrefix(strs: string[]): string {
  strs.sort();

  const firstStr = strs[0];
  const lastStr = strs[strs.length - 1];
  let maxLen = Math.min(firstStr.length, lastStr.length);

  for (let j = 0; j < maxLen; j++) {
    if (firstStr[j] !== lastStr[j]) {
      maxLen = j;
      break;
    }
  }

  return firstStr.substring(0, maxLen);
}
