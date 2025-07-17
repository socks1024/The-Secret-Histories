package TheSecretHistories.Content.Cards.Rites;

import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Content.Cards.Spirits.GrailEdge.SummonGrailEdge;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

public abstract class AbstractSummonRite extends AbstractRite {

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final AbstractSummonOption[] DEFAULT_SUMMON_OPTIONS = new AbstractSummonOption[]{
        new SummonGrailEdge(),
    };

    private final AbstractSummonOption[] summonOptions;

    public AbstractSummonRite(String id, String imgName) {
        this(id, imgName, DEFAULT_SUMMON_OPTIONS);
    }

    public AbstractSummonRite(String id, String imgName, AbstractSummonOption[] summonOptions) {
        super(id, imgName, COST, TYPE, TARGET);
        this.summonOptions = summonOptions;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ChooseOneAction(GetAvailableSummonOptions()));
    }

    protected ArrayList<AbstractCard> GetAvailableSummonOptions() {
        ArrayList<AbstractCard> options = new ArrayList<>();

        for (AbstractSummonOption option : summonOptions) {
            if (option.GetAvailable()) options.add(option.makeCopy());
        }

        return options;
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return !GetAvailableSummonOptions().isEmpty();
    }
}
