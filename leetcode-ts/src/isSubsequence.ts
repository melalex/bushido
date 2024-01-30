function isSubsequence(s: string, t: string): boolean {
  if (s > t) {
    return false;
  }

  let j = 0;

  for (let i = 0; i < t.length; i++) {
    const it = t[i];

    if (it === s[j]) {
      j++;
    }

    if (j >= s.length) {
      return true;
    }
  }

  return j >= s.length;
}
