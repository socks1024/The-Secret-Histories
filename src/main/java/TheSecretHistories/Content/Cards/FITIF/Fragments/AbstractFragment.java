package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelCard;
import TheSecretHistories.Utils.DeckUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FRAGMENT;

public abstract class AbstractFragment extends TemplateMultiLevelCard {

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;

    private static final int UPGRADE_TIMES_LIMIT = 6;

    public AbstractFragment(String id, CardTags principleTag) {
        super(id, COST, TYPE, COLOR, RARITY, TARGET, UPGRADE_TIMES_LIMIT);

        this.tags.add(FRAGMENT);
        this.tags.add(principleTag);

        this.principleTag = principleTag;

        this.principleCount = this.basePrincipleCount = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradePrincipleCount(2);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple();
    }

    @Override
    public void OnObtain() {
        ArrayList<AbstractCard> cards = DeckUtils.GetCardsInMasterDeck(this.cardID);

        cards.remove(this);

        if (cards.isEmpty()) return;

        for (AbstractCard card : cards) {
            AbstractFragment fragment = (AbstractFragment)card;

            if (!fragment.upgraded) {
                fragment.DoUpgrade(this.timesUpgraded + 1);
                break;
            }
        }

        AbstractDungeon.player.masterDeck.removeCard(this);
    }
}
