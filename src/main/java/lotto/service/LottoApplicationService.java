package lotto.service;

import lotto.domain.*;
import lotto.utils.InputParser;
import lotto.view.consoleinput.ConsoleInput;
import lotto.view.consoleoutput.ConsoleOutput;

import java.util.List;

public class LottoApplicationService {
    private final ConsoleInput consoleInput = new ConsoleInput();
    private final ConsoleOutput consoleOutput = new ConsoleOutput();
    private Money money;
    private LottoCollection lottoCollection;
    private WinningLotto winningLotto;

    private LottoStatistic statistic;

    public void inputMoney() {
        consoleOutput.printDirectiveAboutInputMoney();
        money = Money.of(InputParser.parseToInteger(consoleInput.readInput()));
    }

    public void createLottos() {
        lottoCollection = LottoCollection.of(
                LottoAutoGenerator.generateLottoCollection(money.getMoney())
        );
        consoleOutput.printAmountOfLottos(money.getMoney());
        consoleOutput.printAllNumberOfLottoCollection(lottoCollection);
    }

    public void createWinningLottoNumbers() {
        consoleOutput.printDirectiveAboutInputWinningNumber();
        List<Integer> winningBalls =
                InputParser.parseAllElementToInteger(
                        InputParser.divideInputBySeparator(consoleInput.readInput()));

        consoleOutput.printDirectiveAboutInputBonusNumber();
        Integer bonusBall = InputParser.parseToInteger(consoleInput.readInput());
        winningLotto = WinningLottoGenerator.generateWinningLotto(winningBalls, bonusBall);
    }

    public void getStatisticsOfLotto() {
        statistic = LottoStatistic.of(lottoCollection.countLottoAward(winningLotto));
        consoleOutput.printStatisticsOfWiningLotto(statistic, money.getMoney());
    }
}
