class Solution(object):
	def wordSquares(self, words):
		m = len(words)
		n = len(words[0]) if m else 0
		mdict = collections.defaultdict(set)
		for word in words:
			for i in range(n):
				mdict[word[:i]].add(word)
		matrix = []
		ans = []
		def search(word, line):
			matrix.append(word)
			if line == n:
				ans.append(matrix[:])
			else:
				prefix = ''.join(matrix[x][line] for x in range(line))
				for word in mdict[prefix]:
					search(word, line+1)
			matrix.pop()
		for word in words:
			search(word, 1)
		return ans
