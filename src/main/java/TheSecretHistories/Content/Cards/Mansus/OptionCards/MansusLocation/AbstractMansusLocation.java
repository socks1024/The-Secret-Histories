package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation;

import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;
import TheSecretHistories.Content.Powers.UniqueCards.ToolSecretHistoriesDPower;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public abstract class AbstractMansusLocation extends TemplateOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    private final AbstractCard[] cards;

    public AbstractMansusLocation(String id, String imgName, AbstractCard[] cards) {
        super(id, imgName, COLOR);
        this.cards = cards;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        OnChoseThisOption(abstractPlayer);
    }

    @Override
    public void OnChoseThisOption(AbstractPlayer p) {
        AbstractCard card = cards[new Random().nextInt(cards.length)];

        if (p.hasPower(ToolSecretHistoriesDPower.POWER_ID) && card.hasTag(SECRET_HISTORIES)) {
            for (int i = 0; i < p.getPower(ToolSecretHistoriesDPower.POWER_ID).amount; i++) {
                card.upgrade();
                card.applyPowers();
            }
        }

        addToTop(new MakeTempCardInHandAction(card));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }
}
