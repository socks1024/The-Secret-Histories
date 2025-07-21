package TheSecretHistories.Content.Cards.Rites;

import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Content.Cards.Spirits.Concrete.*;
import TheSecretHistories.Utils.DebugUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
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
        new SummonLanternEdge(),
        new SummonForgeEdge(),
        new SummonForgeMoth(),
        new SummonGrailMoth(),
        new SummonHeartEdge(),
        new SummonLanternSecret(),
        new SummonWinterMoth(),
        new SummonWinterEdge()
    };

    private final AbstractSummonOption[] summonOptions;

    private static final long TIME_INTERVAL = 3;

    public AbstractSummonRite(String id, String imgName) {
        this(id, imgName, DEFAULT_SUMMON_OPTIONS);
    }

    public AbstractSummonRite(String id, String imgName, AbstractSummonOption[] summonOptions) {
        super(id, imgName, COST, TYPE, TARGET);
        this.summonOptions = summonOptions;
    }

    private float rotationTimer = 0F;
    private int previewIndex = 0;

    public void update() {
        super.update();
        if (this.hb.hovered)
            if (this.rotationTimer <= 0.0F) {
                this.rotationTimer = 2.0F;
                this.cardsToPreview = DEFAULT_SUMMON_OPTIONS[previewIndex];
                if (this.previewIndex == DEFAULT_SUMMON_OPTIONS.length - 1) {
                    this.previewIndex = 0;
                } else {
                    this.previewIndex++;
                }
            } else {
                this.rotationTimer -= Gdx.graphics.getDeltaTime();
            }
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

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.selfRetain = true;
    }
}
