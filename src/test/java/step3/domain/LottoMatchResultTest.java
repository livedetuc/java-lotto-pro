package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMatchResultTest {

  private LottoTicket winningTicket;
  @BeforeEach
  void setUp() {
    winningTicket = new LottoTicket(Stream.of(1, 4, 26, 27, 38, 40)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
  }

  @Test
  @DisplayName("로또 숫자 매치 케이스_1Ticket, 4Number match")
  void lottoMatchResult_1Ticket4NumberMatch() {
    LottoTicket myTicket = new LottoTicket(Stream.of(3, 4, 26, 27, 38, 45)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTickets myLottoTickets = new LottoTickets(Collections.singletonList(myTicket));
    LottoMatchResult lottoMatchResult = new LottoMatchResult(myLottoTickets, winningTicket);

    assertEquals(0, lottoMatchResult.getMatchCountNum(3));
    assertEquals(1, lottoMatchResult.getMatchCountNum(4));
    assertEquals(0, lottoMatchResult.getMatchCountNum(5));
    assertEquals(0, lottoMatchResult.getMatchCountNum(6));
  }

  @Test
  @DisplayName("로또 숫자 매치 케이스_1Ticket-2Number, 2Ticket-4Number match each")
  void lottoMatchResult_2Ticket4NumberMatch() {
    LottoTicket myTicket1 = new LottoTicket(Stream.of(3, 4, 26, 27, 38, 45)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTicket myTicket2 = new LottoTicket(Stream.of(4, 27, 27, 38, 39, 45)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTicket myTicket3 = new LottoTicket(Stream.of(4, 8, 29, 30, 31, 42)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));
    LottoTickets myLottoTickets = new LottoTickets(Arrays.asList(myTicket1, myTicket2, myTicket3));
    LottoMatchResult lottoMatchResult = new LottoMatchResult(myLottoTickets, winningTicket);

    assertEquals(0, lottoMatchResult.getMatchCountNum(3));
    assertEquals(2, lottoMatchResult.getMatchCountNum(4));
    assertEquals(0, lottoMatchResult.getMatchCountNum(5));
    assertEquals(0, lottoMatchResult.getMatchCountNum(6));
  }
}
