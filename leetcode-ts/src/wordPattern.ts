function wordPattern(pattern: string, s: string): boolean {
  const words = s.split(" ");
  const dictionary = {};
  const visited = new Set<string>();

  if (words.length !== pattern.length) {
    return false;
  }

  for (let i = 0; i < pattern.length; i++) {
    const letter = pattern[i];
    const word = words[i];

    if (letter in dictionary) {
      if (dictionary[letter] !== word) {
        return false;
      }
    } else if (visited.has(word)) {
      return false;
    } else {
      dictionary[letter] = word;
      visited.add(word);
    }
  }

  return true;
}
