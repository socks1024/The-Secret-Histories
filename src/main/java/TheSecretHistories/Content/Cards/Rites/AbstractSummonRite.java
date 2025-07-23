package TheSecretHistories.Content.Cards.Rites;

import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Content.Cards.Spirits.Options.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
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

    private AbstractCard option;
    private AbstractCard spirit;

    public void update() {
        super.update();
        if (this.hb.hovered)
            if (this.rotationTimer <= 0.0F) {
                this.rotationTimer = 2.0F;

                this.option = DEFAULT_SUMMON_OPTIONS[previewIndex].makeStatEquivalentCopy();
                this.spirit = DEFAULT_SUMMON_OPTIONS[previewIndex].spirit.makeStatEquivalentCopy();

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

    public void renderCardTip(SpriteBatch sb) {
        super.renderCardTip(sb);
        if (this.isLocked || (AbstractDungeon.player != null && (AbstractDungeon.player.isDraggingCard || AbstractDungeon.player.inSingleTargetMode)))
            return;
        float drawScale = 0.5F;
        float yPosition2 = this.current_y + this.hb.height * 0.25F;
        float yPosition3 = this.current_y - this.hb.height * 0.25F;
        if (AbstractDungeon.screen == AbstractDungeon.CurrentScreen.SHOP) {
            yPosition2 = this.current_y - this.hb.height * 0.25F;
            yPosition3 = this.current_y + this.hb.height * 0.25F;
        }
        float xOffset1 = -this.hb.width * 0.75F;
        if (this.current_x > Settings.WIDTH * 0.75F) {
            xOffset1 = -xOffset1;
        }
        float xPosition1 = this.current_x + xOffset1;

        if (this.lowerCardToPreview != null) {
            AbstractCard card = this.lowerCardToPreview.makeStatEquivalentCopy();
            if (card != null) {
                card.drawScale = drawScale;
                card.current_x = xPosition1;
                card.current_y = yPosition3;
                card.render(sb);
            }
        }

        if (this.higherCardToPreview != null) {
            AbstractCard card = this.higherCardToPreview.makeStatEquivalentCopy();
            if (card != null) {
                card.drawScale = drawScale;
                card.current_x = xPosition1;
                card.current_y = yPosition2;
                card.render(sb);
            }
        }
    }

    public void hover() {
        try {
            this.lowerCardToPreview = this.option;
            this.higherCardToPreview = this.spirit;
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
        super.hover();
    }

    public void unhover() {
        super.unhover();
        this.lowerCardToPreview = null;
        this.higherCardToPreview = null;
    }
}
