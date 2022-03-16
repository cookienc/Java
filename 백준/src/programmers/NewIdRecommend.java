package programmers;

public class NewIdRecommend {
	class Solution {
		public String solution(String new_id) {
			IdRecommend idRecommend = new IdRecommend(new_id);

			return idRecommend.kakaoId();
		}

		private class IdRecommend {
			private String id;

			public IdRecommend(String id) {
				this.id = id;
			}

			public String getId() {
				return this.id;
			}

			public String kakaoId() {
				return this.toLowerCase()
						.removeSpecificWord()
						.removeDuplicatePeriod()
						.removeFirstPeriod()
						.removeLastPeriod()
						.isItEmpty()
						.isItInRange()
						.isLowerThanTwo()
						.getId();
			}

			private IdRecommend toLowerCase() {
				this.id = this.id.toLowerCase();
				return this;
			}

			private IdRecommend removeSpecificWord() {
				this.id = this.id.replaceAll("[^0-9a-z\\-\\_\\.]", "");
				return this;
			}

			private IdRecommend removeDuplicatePeriod() {
				this.id = this.id.replaceAll("[.]{2,}", ".");
				return this;
			}

			private IdRecommend removeFirstPeriod() {
				this.id = this.id.replaceAll("^[.]","");
				return this;
			}

			private IdRecommend removeLastPeriod() {
				this.id = this.id.replaceAll("[.]$", "");
				return this;
			}

			private IdRecommend isItEmpty() {

				if (this.id.length() == 0) {
					this.id = "a";
				}
				return this;
			}

			private IdRecommend isItInRange() {
				if (this.id.length() >= 16) {
					this.id = this.id.substring(0, 15);
					this.removeLastPeriod();
				}
				return this;
			}

			private IdRecommend isLowerThanTwo() {
				if (this.id.length() == 1) {
					String tmp = this.id;
					this.id += tmp + tmp;
					return this;
				}

				if (this.id.length() == 2) {
					String tmp = String.valueOf(this.id.charAt(1));
					this.id += tmp;
					return this;
				}
				return this;
			}
		}
	}
}
