package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.cards.AbstractCard;

public abstract class AbstractShowedLocation extends AbstractMansusLocation {
    public AbstractShowedLocation(String id, String imgName, AbstractCard[] cards) {
        super(id, imgName, cards);

        this.chosenCard = cards[MathUtils.random(cards.length - 1)].makeStatEquivalentCopy();
    }

    @Override
    public void update() {
        super.update();
        if (this.hb.hovered) {
            this.cardsToPreview = chosenCard;
        }
    }
}
