package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningProfitTest {

  @ParameterizedTest
  @CsvSource(value = {"100 : 1000: 0.1", "5000 : 14000 : 0.35714287"}, delimiter = ':')
  void winningProfitTest(int winningPrice, int purchasePrice, float profit) {
    LottoWinningPrice lottoWinningPrice = new LottoWinningPrice() {
      @Override
      public int getWinningPrice() {
        return winningPrice;
      }
    };

    LottoTicketsPrice lottoTicketsPrice = new LottoTicketsPrice() {
      @Override
      public int getTicketsPrice() {
        return purchasePrice;
      }
    };

    LottoWinningProfit lottoWinningProfit = new LottoWinningProfit(lottoWinningPrice,
        lottoTicketsPrice);
    assertEquals(profit, lottoWinningProfit.getProfit());
  }
}
